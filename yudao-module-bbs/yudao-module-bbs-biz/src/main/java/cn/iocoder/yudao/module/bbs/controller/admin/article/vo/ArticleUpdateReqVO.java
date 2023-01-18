package cn.iocoder.yudao.module.bbs.controller.admin.article.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ApiModel("管理后台 - 文章更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleUpdateReqVO extends ArticleBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "1")
    @NotNull(message = "id不能为空")
    private Long id;

    @ApiModelProperty(value = "外链")
    private String outsideLink;

}
