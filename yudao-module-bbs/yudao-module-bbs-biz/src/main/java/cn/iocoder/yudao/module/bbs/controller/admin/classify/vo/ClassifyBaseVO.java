package cn.iocoder.yudao.module.bbs.controller.admin.classify.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 分类 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ClassifyBaseVO {

    @ApiModelProperty(value = "分类名", required = true, example = "王五")
    @NotNull(message = "分类名不能为空")
    private String classifyName;

    @ApiModelProperty(value = "分类简介", example = "你猜")
    private String description;

    @ApiModelProperty(value = "显示顺序", required = true)
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    @ApiModelProperty(value = "状态", required = true, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
