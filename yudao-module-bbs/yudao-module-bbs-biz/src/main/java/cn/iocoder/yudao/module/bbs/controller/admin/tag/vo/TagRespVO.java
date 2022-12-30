package cn.iocoder.yudao.module.bbs.controller.admin.tag.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 标签 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TagRespVO extends TagBaseVO {

    @ApiModelProperty(value = "编号", required = true, example = "1024")
    private Long id;

    @ApiModelProperty(value = "标签简介", example = "0")
    private Integer clickCount;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
