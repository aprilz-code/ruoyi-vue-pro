package cn.iocoder.yudao.module.bbs.controller.app.jd.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@ApiModel("口令解析 Req vo")
@Data
@ToString(callSuper = true)
public class AppJDJComExchangeReqVO {

    @ApiModelProperty(value = "参数名称", required = true, example = "数据库名")
    @NotBlank(message = "参数名称不能为空")
    @Size(max = 100, message = "参数名称不能超过100个字符")
    private String code;
}
