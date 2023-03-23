package cn.iocoder.yudao.module.bbs.dal.dataobject.mijob;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 米job DO
 *
 * @author 芋道源码
 */
@TableName("bbs_mi_job")
@KeySequence("bbs_mi_job_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiJobDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 卡密
     */
    private String cardNo;
    /**
     * 执行计划
     */
    private String cron;
    /**
     * 最小步数
     */
    private Integer minStep;
    /**
     * 最大步数
     */
    private Integer maxStep;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     * xxljobId
     */
    private Integer jobId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

}
