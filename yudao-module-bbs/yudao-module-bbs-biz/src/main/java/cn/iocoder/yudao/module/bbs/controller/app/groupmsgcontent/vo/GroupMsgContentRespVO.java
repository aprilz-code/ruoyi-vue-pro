package cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 群聊消息内容 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GroupMsgContentRespVO extends GroupMsgContentBaseVO {

    @ApiModelProperty(value = "消息内容编号", required = true, example = "2858")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
