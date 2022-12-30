package cn.iocoder.yudao.module.bbs.controller.admin.classify.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 分类更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClassifyUpdateReqVO extends ClassifyBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "1")
    @NotNull(message = "id不能为空")
    private Long id;

}
