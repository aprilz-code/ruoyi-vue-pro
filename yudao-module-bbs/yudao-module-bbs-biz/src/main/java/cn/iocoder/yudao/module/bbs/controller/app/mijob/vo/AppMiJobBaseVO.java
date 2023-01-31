package cn.iocoder.yudao.module.bbs.controller.app.mijob.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 米job Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppMiJobBaseVO {

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "卡密")
    private String cardNo;

    @ApiModelProperty(value = "执行计划")
    private String cron;

    @ApiModelProperty(value = "最小步数", required = true)
    @NotNull(message = "最小步数不能为空")
    private Integer minStep;

    @ApiModelProperty(value = "最大步数", required = true)
    @NotNull(message = "最大步数不能为空")
    private Integer maxStep;

    @ApiModelProperty(value = "结束时间", required = true)
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @ApiModelProperty(value = "xxljobId", required = true, example = "2800")
    @NotNull(message = "xxljobId不能为空")
    private Integer jobId;

    @ApiModelProperty(value = "用户id", example = "27359")
    private Integer userId;

    @ApiModelProperty(value = "状态", required = true, example = "2")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
