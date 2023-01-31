package cn.iocoder.yudao.module.bbs.controller.app.mijob.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("用户 APP - 米job分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMiJobPageReqVO extends PageParam {

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "卡密")
    private String cardNo;

    @ApiModelProperty(value = "执行计划")
    private String cron;

    @ApiModelProperty(value = "最小步数")
    private Integer minStep;

    @ApiModelProperty(value = "最大步数")
    private Integer maxStep;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] endTime;

    @ApiModelProperty(value = "xxljobId", example = "2800")
    private Integer jobId;

    @ApiModelProperty(value = "用户id", example = "27359")
    private Integer userId;

    @ApiModelProperty(value = "状态", example = "2")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
