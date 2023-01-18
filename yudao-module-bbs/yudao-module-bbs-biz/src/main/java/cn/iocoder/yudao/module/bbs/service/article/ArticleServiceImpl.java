package cn.iocoder.yudao.module.bbs.service.article;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bbs.controller.admin.article.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.article.ArticleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.bbs.convert.article.ArticleConvert;
import cn.iocoder.yudao.module.bbs.dal.mysql.article.ArticleMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;

/**
 * 文章 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Long createArticle(ArticleCreateReqVO createReqVO) {
        // 插入
        ArticleDO article = ArticleConvert.INSTANCE.convert(createReqVO);
        articleMapper.insert(article);
        // 返回
        return article.getId();
    }

    @Override
    public void updateArticle(ArticleUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateArticleExists(updateReqVO.getId());
        // 更新
        ArticleDO updateObj = ArticleConvert.INSTANCE.convert(updateReqVO);
        articleMapper.updateById(updateObj);
    }

    @Override
    public void deleteArticle(Long id) {
        // 校验存在
        this.validateArticleExists(id);
        // 删除
        articleMapper.deleteById(id);
    }

    private void validateArticleExists(Long id) {
        if (articleMapper.selectById(id) == null) {
            throw exception(ARTICLE_NOT_EXISTS);
        }
    }

    @Override
    public ArticleDO getArticle(Long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<ArticleDO> getArticleList(Collection<Long> ids) {
        return articleMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ArticleDO> getArticlePage(ArticlePageReqVO pageReqVO) {
        return articleMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ArticleDO> getArticleList(ArticleExportReqVO exportReqVO) {
        return articleMapper.selectList(exportReqVO);
    }

}
