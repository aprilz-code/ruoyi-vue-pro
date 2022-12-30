package cn.iocoder.yudao.module.bbs.controller.admin.classify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 分类 Excel 导出 Request VO", description = "参数和 ClassifyPageReqVO 是一致的")
@Data
public class ClassifyExportReqVO {

    @ApiModelProperty(value = "分类名", example = "王五")
    private String classifyName;

    @ApiModelProperty(value = "点击数", example = "4169")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Integer[] clickCount;

    @ApiModelProperty(value = "状态", example = "0")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

}
