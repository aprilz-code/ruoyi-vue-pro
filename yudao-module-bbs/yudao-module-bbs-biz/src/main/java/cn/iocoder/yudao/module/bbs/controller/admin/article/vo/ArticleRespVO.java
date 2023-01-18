package cn.iocoder.yudao.module.bbs.controller.admin.article.vo;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.*;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 文章 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleRespVO extends ArticleBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "文章点击数", example = "14428")
    private Integer clickCount;

    @ApiModelProperty(value = "文章收藏数", example = "23278")
    private Integer collectCount;

    @ApiModelProperty(value = "文章分享数", example = "18113")
    private Integer shareCount;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "tagNames", required = true)
    @NotNull(message = "tagNames不能为空")
    private List<String> tagNames;

}
