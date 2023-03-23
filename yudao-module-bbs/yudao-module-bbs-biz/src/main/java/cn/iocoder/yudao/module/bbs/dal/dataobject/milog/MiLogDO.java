package cn.iocoder.yudao.module.bbs.dal.dataobject.milog;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 米日志 DO
 *
 * @author 芋道源码
 */
@TableName("bbs_mi_log")
@KeySequence("bbs_mi_log_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiLogDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 最小步数
     */
    private Integer minStep;
    /**
     * 最大步数
     */
    private Integer maxStep;
    /**
     * 实际步数
     */
    private Integer realStep;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 来源 h5 xxl
     */
    private String source;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

}
