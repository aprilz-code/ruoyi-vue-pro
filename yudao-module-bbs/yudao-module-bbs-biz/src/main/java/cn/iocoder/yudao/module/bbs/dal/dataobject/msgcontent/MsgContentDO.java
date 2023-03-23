package cn.iocoder.yudao.module.bbs.dal.dataobject.msgcontent;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 私聊消息内容 DO
 *
 * @author 芋道源码
 */
@TableName("bbs_msg_content")
@KeySequence("bbs_msg_content_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgContentDO extends BaseDO {

    /**
     * 消息内容编号
     */
    @TableId
    private Long id;
    /**
     * 私聊id,以用户小的id拼上-用户大的id
     */
    private String privateChatId;
    /**
     * 发送者的编号
     */
    private Integer fromId;
    /**
     * 发送者的昵称
     */
    private String fromName;
    /**
     * 发送者的头像
     */
    private String fromProfile;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息类型编码
     */
    private String messageType;

}
