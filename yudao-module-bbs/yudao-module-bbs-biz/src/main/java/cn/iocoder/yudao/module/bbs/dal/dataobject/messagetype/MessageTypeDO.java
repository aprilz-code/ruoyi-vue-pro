package cn.iocoder.yudao.module.bbs.dal.dataobject.messagetype;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 消息类型 DO
 *
 * @author 芋道源码
 */
@TableName("bbs_message_type")
@KeySequence("bbs_message_type_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageTypeDO extends BaseDO {

    /**
     * 消息内容编号
     */
    @TableId
    private Long id;
    /**
     * 消息类型编码
     */
    private String typeCode;
    /**
     * 消息类型名称
     */
    private String typeName;

}
