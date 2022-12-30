package cn.iocoder.yudao.module.bbs.controller.admin.tag.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 标签 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TagBaseVO {

    @ApiModelProperty(value = "标签内容", required = true, example = "标签名")
    @NotNull(message = "标签内容不能为空")
    private String content;

    @ApiModelProperty(value = "显示顺序", required = true, example = "1")
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    @ApiModelProperty(value = "状态（0正常 1停用）", required = true)
    @NotNull(message = "状态（0正常 1停用）不能为空")
    private Integer status;

}
