package cn.iocoder.yudao.module.bbs.dal.dataobject.article;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.framework.mybatis.core.type.LongListTypeHandler;
import cn.iocoder.yudao.module.bbs.enums.DictTypeConstants;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

/**
 * 文章 DO
 *
 * @author 芋道源码
 */
@TableName(value = "bbs_article", autoResultMap = true)
@KeySequence("bbs_article_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 标题缩略图地址
     */
    private String thumb;
    /**
     * 文章简介
     */
    private String summary;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 标签ids
     */
    @TableField(typeHandler = LongListTypeHandler.class)
    private List<Long> tagIds;
    /**
     * 文章点击数
     */
    private Integer clickCount;
    /**
     * 文章收藏数
     */
    private Integer collectCount;
    /**
     * 文章分享数
     */
    private Integer shareCount;
    /**
     * 是否原创（0:不是 1：是）
     */
    @ExcelProperty(value = "是否原创", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STATUS)
    private Integer isOriginal;
    /**
     * 作者
     */
    private String author;
    /**
     * 文章出处
     */
    private String articlesPart;
    /**
     * 文章分类UID
     */
    private String classifyId;
    /**
     * 是否置顶（0不是 1是）
     */
    @ExcelProperty(value = "是否置顶", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STATUS)
    private Integer isTop;
    /**
     * 推荐等级(0-5)
     */
    private Integer level;
    /**
     * 是否开启评论(0:开启 1:关闭)
     */
    @ExcelProperty(value = "是否开启评论", converter = DictConvert.class)
    @DictFormat("common_status")
    private Integer openComment;
    /**
     * 类型【0 文章， 1：推广】
     */
    @ExcelProperty(value = "类型", converter = DictConvert.class)
    @DictFormat("BBS_ARTICLE_TYPE")
    private String type;
    /**
     * 外链
     */
    private String outsideLink;
    /**
     * 状态
     */
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status")
    private Integer status;

}
