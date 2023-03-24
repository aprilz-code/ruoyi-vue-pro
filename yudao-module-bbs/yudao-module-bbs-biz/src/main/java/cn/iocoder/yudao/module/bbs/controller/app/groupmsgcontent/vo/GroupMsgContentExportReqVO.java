package cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo;

import lombok.*;
import io.swagger.annotations.*;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 群聊消息内容 Excel 导出 Request VO", description = "参数和 GroupMsgContentPageReqVO 是一致的")
@Data
public class GroupMsgContentExportReqVO {

    @ApiModelProperty(value = "群聊id", example = "15868")
    private Long groupId;

    @ApiModelProperty(value = "发送者的编号", example = "77")
    private Long fromId;

    @ApiModelProperty(value = "发送者的昵称", example = "李四")
    private String fromName;

    @ApiModelProperty(value = "发送者的头像")
    private String fromProfile;

    @ApiModelProperty(value = "消息内容")
    private String content;

    @ApiModelProperty(value = "消息类型编码", example = "2")
    private String messageType;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
