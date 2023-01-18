package cn.iocoder.yudao.module.bbs.controller.admin.article.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.bbs.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 文章 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ArticleExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("文章标题")
    private String title;

    @ExcelProperty("标题缩略图地址")
    private String thumb;

    @ExcelProperty("文章简介")
    private String summary;

    @ExcelProperty("文章内容")
    private String content;

    @ExcelProperty(value = "标签ids")
    private List<Long> tagIds;

    @ExcelProperty("文章点击数")
    private Integer clickCount;

    @ExcelProperty("文章收藏数")
    private Integer collectCount;

    @ExcelProperty("文章分享数")
    private Integer shareCount;

    @ExcelProperty(value = "是否原创（0:不是 1：是）", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STATUS)
    private Integer isOriginal;

    @ExcelProperty("作者")
    private String author;

    @ExcelProperty("文章出处")
    private String articlesPart;

    @ExcelProperty("文章分类UID")
    private String classifyId;

    @ExcelProperty("是否置顶（0不是 1是）")
    @DictFormat(DictTypeConstants.BOOLEAN_STATUS)
    private Integer isTop;

    @ExcelProperty(value = "推荐等级")
    private Integer level;

    @ExcelProperty(value = "是否开启评论(0:否 1:是)", converter = DictConvert.class)
    @DictFormat("common_status")
    private Integer openComment;

    @ExcelProperty(value = "类型【0 文章， 1：推广】", converter = DictConvert.class)
    @DictFormat("BBS_ARTICLE_TYPE")
    private String type;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status")
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
