package cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 私聊消息内容 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MsgContentRespVO extends MsgContentBaseVO {

    @ApiModelProperty(value = "消息内容编号", required = true, example = "12344")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
