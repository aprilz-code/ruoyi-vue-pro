package cn.iocoder.yudao.module.bbs.controller.app.micard.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "用户 APP - 米卡密 Excel 导出 Request VO", description = "参数和 MiCardPageReqVO 是一致的")
@Data
public class AppMiCardExportReqVO {

    @ApiModelProperty(value = "卡密")
    private String cardNo;

    @ApiModelProperty(value = "1.7day 2.1年 3.永久", example = "1")
    private Integer type;

    @ApiModelProperty(value = "状态", example = "1")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
