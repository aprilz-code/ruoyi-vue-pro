package cn.iocoder.yudao.module.bbs.controller.app.milog.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 米日志 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppMiLogBaseVO {

    @ApiModelProperty(value = "最小步数", required = true)
    @NotNull(message = "最小步数不能为空")
    private Integer minStep;

    @ApiModelProperty(value = "最大步数", required = true)
    @NotNull(message = "最大步数不能为空")
    private Integer maxStep;

    @ApiModelProperty(value = "实际步数", required = true)
    @NotNull(message = "实际步数不能为空")
    private Integer realStep;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "来源 h5 xxl")
    private String source;

    @ApiModelProperty(value = "状态", required = true, example = "2")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
