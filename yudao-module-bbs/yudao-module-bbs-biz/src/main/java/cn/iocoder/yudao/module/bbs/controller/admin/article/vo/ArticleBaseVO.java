package cn.iocoder.yudao.module.bbs.controller.admin.article.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 文章 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ArticleBaseVO {

    @ApiModelProperty(value = "文章标题", required = true)
    @NotNull(message = "文章标题不能为空")
    private String title;

    @ApiModelProperty(value = "标题缩略图地址")
    private String thumb;

    @ApiModelProperty(value = "文章简介")
    private String summary;

    @ApiModelProperty(value = "文章内容", required = true)
    @NotNull(message = "文章内容不能为空")
    private String content;

    @ApiModelProperty(value = "标签ids", required = true)
    @NotNull(message = "标签ids不能为空")
    private List<Long> tagIds;

    @ApiModelProperty(value = "是否原创（0:不是 1：是）", required = true)
    @NotNull(message = "是否原创（0:不是 1：是）不能为空")
    private Integer isOriginal;

    @ApiModelProperty(value = "作者", required = true)
    @NotNull(message = "作者不能为空")
    private String author;

    @ApiModelProperty(value = "文章出处")
    private String articlesPart;

    @ApiModelProperty(value = "文章分类UID", required = true, example = "9671")
    @NotNull(message = "文章分类UID不能为空")
    private String classifyId;

    @ApiModelProperty(value = "是否置顶（0不是 1是）", required = true)
    @NotNull(message = "是否置顶（0不是 1是）不能为空")
    private Integer isTop;

    @ApiModelProperty(value = "推荐等级(0-5)")
    private Integer level;

    @ApiModelProperty(value = "是否开启评论(0:否 1:是)", required = true)
    @NotNull(message = "是否开启评论(0:否 1:是)不能为空")
    private Integer openComment;

    @ApiModelProperty(value = "类型【0 文章， 1：推广】", required = true, example = "1")
    @NotNull(message = "类型【0 文章， 1：推广】不能为空")
    private String type;

    @ApiModelProperty(value = "状态", required = true, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
