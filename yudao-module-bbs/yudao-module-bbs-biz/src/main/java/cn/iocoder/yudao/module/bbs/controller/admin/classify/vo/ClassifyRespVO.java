package cn.iocoder.yudao.module.bbs.controller.admin.classify.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 分类 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClassifyRespVO extends ClassifyBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "点击数", example = "4169")
    private Integer clickCount;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
