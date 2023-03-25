package cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 群聊消息内容 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GroupMsgContentRespVO extends GroupMsgContentBaseVO {

    @ApiModelProperty(value = "消息内容编号", required = true, example = "2858")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime createTime;

}
