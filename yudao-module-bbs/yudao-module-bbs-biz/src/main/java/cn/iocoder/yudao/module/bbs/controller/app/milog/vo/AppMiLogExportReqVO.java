package cn.iocoder.yudao.module.bbs.controller.app.milog.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "用户 APP - 米日志 Excel 导出 Request VO", description = "参数和 MiLogPageReqVO 是一致的")
@Data
public class AppMiLogExportReqVO {

    @ApiModelProperty(value = "最小步数")
    private Integer minStep;

    @ApiModelProperty(value = "最大步数")
    private Integer maxStep;

    @ApiModelProperty(value = "实际步数")
    private Integer realStep;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "来源 h5 xxl")
    private String source;

    @ApiModelProperty(value = "状态", example = "2")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
