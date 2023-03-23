package cn.iocoder.yudao.module.bbs.service.msgcontent;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.msgcontent.MsgContentDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.msgcontent.MsgContentMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link MsgContentServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MsgContentServiceImpl.class)
public class MsgContentServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MsgContentServiceImpl msgContentService;

    @Resource
    private MsgContentMapper msgContentMapper;

    @Test
    public void testCreateMsgContent_success() {
        // 准备参数
        MsgContentCreateReqVO reqVO = randomPojo(MsgContentCreateReqVO.class);

        // 调用
        Long msgContentId = msgContentService.createMsgContent(reqVO);
        // 断言
        assertNotNull(msgContentId);
        // 校验记录的属性是否正确
        MsgContentDO msgContent = msgContentMapper.selectById(msgContentId);
        assertPojoEquals(reqVO, msgContent);
    }

    @Test
    public void testUpdateMsgContent_success() {
        // mock 数据
        MsgContentDO dbMsgContent = randomPojo(MsgContentDO.class);
        msgContentMapper.insert(dbMsgContent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MsgContentUpdateReqVO reqVO = randomPojo(MsgContentUpdateReqVO.class, o -> {
            o.setId(dbMsgContent.getId()); // 设置更新的 ID
        });

        // 调用
        msgContentService.updateMsgContent(reqVO);
        // 校验是否更新正确
        MsgContentDO msgContent = msgContentMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, msgContent);
    }

    @Test
    public void testUpdateMsgContent_notExists() {
        // 准备参数
        MsgContentUpdateReqVO reqVO = randomPojo(MsgContentUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> msgContentService.updateMsgContent(reqVO), MSG_CONTENT_NOT_EXISTS);
    }

    @Test
    public void testDeleteMsgContent_success() {
        // mock 数据
        MsgContentDO dbMsgContent = randomPojo(MsgContentDO.class);
        msgContentMapper.insert(dbMsgContent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMsgContent.getId();

        // 调用
        msgContentService.deleteMsgContent(id);
       // 校验数据不存在了
       assertNull(msgContentMapper.selectById(id));
    }

    @Test
    public void testDeleteMsgContent_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> msgContentService.deleteMsgContent(id), MSG_CONTENT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMsgContentPage() {
       // mock 数据
       MsgContentDO dbMsgContent = randomPojo(MsgContentDO.class, o -> { // 等会查询到
           o.setPrivateChatId(null);
           o.setFromId(null);
           o.setFromName(null);
           o.setFromProfile(null);
           o.setContent(null);
           o.setMessageType(null);
           o.setCreateTime(null);
       });
       msgContentMapper.insert(dbMsgContent);
       // 测试 privateChatId 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setPrivateChatId(null)));
       // 测试 fromId 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setFromId(null)));
       // 测试 fromName 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setFromName(null)));
       // 测试 fromProfile 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setFromProfile(null)));
       // 测试 content 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setContent(null)));
       // 测试 messageType 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setMessageType(null)));
       // 测试 createTime 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setCreateTime(null)));
       // 准备参数
       MsgContentPageReqVO reqVO = new MsgContentPageReqVO();
       reqVO.setPrivateChatId(null);
       reqVO.setFromId(null);
       reqVO.setFromName(null);
       reqVO.setFromProfile(null);
       reqVO.setContent(null);
       reqVO.setMessageType(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<MsgContentDO> pageResult = msgContentService.getMsgContentPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMsgContent, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMsgContentList() {
       // mock 数据
       MsgContentDO dbMsgContent = randomPojo(MsgContentDO.class, o -> { // 等会查询到
           o.setPrivateChatId(null);
           o.setFromId(null);
           o.setFromName(null);
           o.setFromProfile(null);
           o.setContent(null);
           o.setMessageType(null);
           o.setCreateTime(null);
       });
       msgContentMapper.insert(dbMsgContent);
       // 测试 privateChatId 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setPrivateChatId(null)));
       // 测试 fromId 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setFromId(null)));
       // 测试 fromName 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setFromName(null)));
       // 测试 fromProfile 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setFromProfile(null)));
       // 测试 content 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setContent(null)));
       // 测试 messageType 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setMessageType(null)));
       // 测试 createTime 不匹配
       msgContentMapper.insert(cloneIgnoreId(dbMsgContent, o -> o.setCreateTime(null)));
       // 准备参数
       MsgContentExportReqVO reqVO = new MsgContentExportReqVO();
       reqVO.setPrivateChatId(null);
       reqVO.setFromId(null);
       reqVO.setFromName(null);
       reqVO.setFromProfile(null);
       reqVO.setContent(null);
       reqVO.setMessageType(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<MsgContentDO> list = msgContentService.getMsgContentList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMsgContent, list.get(0));
    }

}
