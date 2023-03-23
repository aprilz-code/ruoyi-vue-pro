package cn.iocoder.yudao.module.bbs.dal.dataobject.micard;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 米卡密 DO
 *
 * @author 芋道源码
 */
@TableName("bbs_mi_card")
@KeySequence("bbs_mi_card_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiCardDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 卡密
     */
    private String cardNo;
    /**
     * 1.7day 2.1年 3.永久
     */
    private Integer type;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

}
