package cn.iocoder.yudao.module.bbs.controller.admin.article.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("管理后台 - 文章创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticleCreateReqVO extends ArticleBaseVO {

    @ApiModelProperty(value = "外链")
    private String outsideLink;

}
