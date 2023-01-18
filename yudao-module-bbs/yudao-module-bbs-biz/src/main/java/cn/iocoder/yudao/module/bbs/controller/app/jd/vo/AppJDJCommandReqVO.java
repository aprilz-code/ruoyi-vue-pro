package cn.iocoder.yudao.module.bbs.controller.app.jd.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@ApiModel("生成口令Reqvo")
@Data
@ToString(callSuper = true)
public class AppJDJCommandReqVO {

    @ApiModelProperty(value = "活动地址", required = true, example = "https://xx.com")
    @NotBlank(message = "活动地址不能为空")
    @Size(max = 500, message = "活动地址不能超过100个字符")
    private String url;

    @ApiModelProperty(value = "活动标题", required = true, example = "")
    @NotBlank(message = "活动标题不能为空")
    @Size(max = 100, message = "活动标题不能超过100个字符")
    private String title;

    @ApiModelProperty(value = "图片地址", required = true, example = "")
    @Size(max = 100, message = "图片地址不能超过100个字符")
    private String img;
}
