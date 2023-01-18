package cn.iocoder.yudao.module.bbs.dal.mysql.article;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bbs.dal.dataobject.article.ArticleDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bbs.controller.admin.article.vo.*;

/**
 * 文章 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ArticleMapper extends BaseMapperX<ArticleDO> {

    default PageResult<ArticleDO> selectPage(ArticlePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ArticleDO>()
                .eqIfPresent(ArticleDO::getTitle, reqVO.getTitle())
                .eqIfPresent(ArticleDO::getThumb, reqVO.getThumb())
                .eqIfPresent(ArticleDO::getSummary, reqVO.getSummary())
                .eqIfPresent(ArticleDO::getContent, reqVO.getContent())
                .eqIfPresent(ArticleDO::getTagIds, reqVO.getTagIds())
                .eqIfPresent(ArticleDO::getIsOriginal, reqVO.getIsOriginal())
                .eqIfPresent(ArticleDO::getArticlesPart, reqVO.getArticlesPart())
                .eqIfPresent(ArticleDO::getClassifyId, reqVO.getClassifyId())
                .eqIfPresent(ArticleDO::getIsTop, reqVO.getIsTop())
                .eqIfPresent(ArticleDO::getLevel, reqVO.getLevel())
                .eqIfPresent(ArticleDO::getOpenComment, reqVO.getOpenComment())
                .eqIfPresent(ArticleDO::getType, reqVO.getType())
                .eqIfPresent(ArticleDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ArticleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ArticleDO::getId));
    }

    default List<ArticleDO> selectList(ArticleExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ArticleDO>()
                .eqIfPresent(ArticleDO::getTitle, reqVO.getTitle())
                .eqIfPresent(ArticleDO::getThumb, reqVO.getThumb())
                .eqIfPresent(ArticleDO::getSummary, reqVO.getSummary())
                .eqIfPresent(ArticleDO::getContent, reqVO.getContent())
                .eqIfPresent(ArticleDO::getTagIds, reqVO.getTagIds())
                .eqIfPresent(ArticleDO::getIsOriginal, reqVO.getIsOriginal())
                .eqIfPresent(ArticleDO::getArticlesPart, reqVO.getArticlesPart())
                .eqIfPresent(ArticleDO::getClassifyId, reqVO.getClassifyId())
                .eqIfPresent(ArticleDO::getIsTop, reqVO.getIsTop())
                .eqIfPresent(ArticleDO::getLevel, reqVO.getLevel())
                .eqIfPresent(ArticleDO::getOpenComment, reqVO.getOpenComment())
                .eqIfPresent(ArticleDO::getType, reqVO.getType())
                .eqIfPresent(ArticleDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ArticleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ArticleDO::getId));
    }

}
