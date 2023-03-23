package cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 消息类型更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MessageTypeUpdateReqVO extends MessageTypeBaseVO {

    @ApiModelProperty(value = "消息内容编号", required = true, example = "3754")
    @NotNull(message = "消息内容编号不能为空")
    private Long id;

}
