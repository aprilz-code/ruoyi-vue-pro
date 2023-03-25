package cn.iocoder.yudao.module.bbs.controller.app.chat;

import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.bbs.controller.app.chat.vo.Message;
import cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo.MsgContentCreateReqVO;
import cn.iocoder.yudao.module.bbs.dal.dataobject.groupmsgcontent.GroupMsgContentDO;
import cn.iocoder.yudao.module.bbs.dal.dataobject.msgcontent.MsgContentDO;
import cn.iocoder.yudao.module.bbs.service.groupmsgcontent.GroupMsgContentService;
import cn.iocoder.yudao.module.member.api.user.MemberUserApi;
import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import com.github.binarywang.java.emoji.EmojiConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Date;

/**
 * @author Hai
 * @date 2020/6/16 - 23:34
 */
@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MemberUserApi memberUserApi;

    EmojiConverter emojiConverter = EmojiConverter.getInstance();

    @Autowired
    private GroupMsgContentService groupMsgContentService;

    /**
     * 单聊的消息的接受与转发
     *
     * @param message
     */
    @MessageMapping("/ws/privateChat")
    public void handleMessage(MsgContentDO message) {
        Long loginUserId = SecurityFrameworkUtils.getLoginUserId();
        MemberUserRespDTO user = memberUserApi.getUser(loginUserId);
        message.setFromName(user.getNickname());
        message.setFromId(loginUserId);
        simpMessagingTemplate.convertAndSendToUser(message.getToId().toString(), "/queue/chat", message);
    }


    /**
     * 群聊的消息接受与转发
     *
     * @param groupMsgContent
     */
    @MessageMapping("/ws/groupChat")
    public void handleGroupMessage(GroupMsgContentDO groupMsgContent) {
        Long loginUserId = SecurityFrameworkUtils.getLoginUserId();
        MemberUserRespDTO currentUser = memberUserApi.getUser(loginUserId);
        //处理emoji内容,转换成unicode编码
        groupMsgContent.setContent(emojiConverter.toHtml(groupMsgContent.getContent()));
        //保证来源正确性，从Security中获取用户信息
        groupMsgContent.setFromId(currentUser.getId());
        groupMsgContent.setFromName(currentUser.getNickname());
        groupMsgContent.setFromProfile(currentUser.getAvatar());
        //保存该条群聊消息记录到数据库中
        groupMsgContentService.insert(groupMsgContent);
        //转发该条数据
        simpMessagingTemplate.convertAndSend("/topic/greetings", groupMsgContent);
    }

    /**
     * 接受前端发来的消息，获得图灵机器人回复并转发回给发送者
     * @param message
     * @throws IOException
     */
//  @MessageMapping("/ws/robotChat")
//  public void handleRobotChatMessage(Message message) throws IOException {
//    Long loginUserId = SecurityFrameworkUtils.getLoginUserId();
//    MemberUserRespDTO user = memberUserApi.getUser(loginUserId);
//    //接收到的消息
//    message.setFrom(user.getUserName());
//    message.setCreateTime(new Date());
//    message.setFromNickname(user.getNickname());
//    message.setFromUserProfile(user.getAvatar());
//    //发送消息内容给机器人，获得回复
//    String result = TuLingUtil.replyMessage(message.getContent());
//    //构建返回消息JSON字符串
//    Message resultMessage = new Message();
//    resultMessage.setFrom("瓦力");
//    resultMessage.setCreateTime(new Date());
//    resultMessage.setFromNickname("瓦力");
//    resultMessage.setContent(result);
//    //回送机器人回复的消息给发送者
//    simpMessagingTemplate.convertAndSendToUser(message.getFrom(),"/queue/robot",resultMessage);
//
//  }
}
