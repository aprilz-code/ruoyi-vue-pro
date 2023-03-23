package cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 消息类型 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MessageTypeRespVO extends MessageTypeBaseVO {

    @ApiModelProperty(value = "消息内容编号", required = true, example = "3754")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
