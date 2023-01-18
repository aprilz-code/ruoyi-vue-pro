package cn.iocoder.yudao.module.bbs.controller.admin.article.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel("管理后台 - 文章分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ArticlePageReqVO extends PageParam {

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "标题缩略图地址")
    private String thumb;

    @ApiModelProperty(value = "文章简介")
    private String summary;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "标签ids")
    private List<Long> tagIds;

    @ApiModelProperty(value = "是否原创（0:不是 1：是）")
    private Integer isOriginal;

    @ApiModelProperty(value = "文章出处")
    private String articlesPart;

    @ApiModelProperty(value = "文章分类UID", example = "9671")
    private String classifyId;

    @ApiModelProperty(value = "是否置顶（0不是 1是）")
    private Integer isTop;

    @ApiModelProperty(value = "推荐等级(0-5)")
    private Boolean level;

    @ApiModelProperty(value = "是否开启评论(0:否 1:是)")
    private Integer openComment;

    @ApiModelProperty(value = "类型【0 文章， 1：推广】", example = "1")
    private String type;

    @ApiModelProperty(value = "状态", example = "0")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
