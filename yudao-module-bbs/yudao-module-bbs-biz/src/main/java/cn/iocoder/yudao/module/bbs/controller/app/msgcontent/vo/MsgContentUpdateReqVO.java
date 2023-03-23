package cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 私聊消息内容更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MsgContentUpdateReqVO extends MsgContentBaseVO {

    @ApiModelProperty(value = "消息内容编号", required = true, example = "12344")
    @NotNull(message = "消息内容编号不能为空")
    private Long id;

}
