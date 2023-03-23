package cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo;

import lombok.*;
import io.swagger.annotations.*;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 消息类型 Excel 导出 Request VO", description = "参数和 MessageTypePageReqVO 是一致的")
@Data
public class MessageTypeExportReqVO {

    @ApiModelProperty(value = "消息类型编码")
    private String typeCode;

    @ApiModelProperty(value = "消息类型名称", example = "赵六")
    private String typeName;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
