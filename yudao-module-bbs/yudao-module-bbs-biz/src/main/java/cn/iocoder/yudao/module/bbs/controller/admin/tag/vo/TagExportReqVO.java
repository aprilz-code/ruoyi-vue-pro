package cn.iocoder.yudao.module.bbs.controller.admin.tag.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 标签 Excel 导出 Request VO", description = "参数和 TagPageReqVO 是一致的")
@Data
public class TagExportReqVO {

    @ApiModelProperty(value = "标签内容", example = "标签名")
    private String content;

    @ApiModelProperty(value = "标签简介", example = "0")
    private Integer clickCount;

    @ApiModelProperty(value = "显示顺序", example = "1")
    private Integer sort;

    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
