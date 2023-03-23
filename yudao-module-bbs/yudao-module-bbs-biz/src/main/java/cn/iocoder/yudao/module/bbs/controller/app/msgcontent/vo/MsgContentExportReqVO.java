package cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo;

import lombok.*;
import io.swagger.annotations.*;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 私聊消息内容 Excel 导出 Request VO", description = "参数和 MsgContentPageReqVO 是一致的")
@Data
public class MsgContentExportReqVO {

    @ApiModelProperty(value = "私聊id,以用户小的id拼上-用户大的id", example = "26019")
    private String privateChatId;

    @ApiModelProperty(value = "发送者的编号", example = "29717")
    private Integer fromId;

    @ApiModelProperty(value = "发送者的昵称", example = "王五")
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
