package cn.iocoder.yudao.module.bbs.service.article;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.admin.article.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.article.ArticleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 文章 Service 接口
 *
 * @author 芋道源码
 */
public interface ArticleService {

    /**
     * 创建文章
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createArticle(@Valid ArticleCreateReqVO createReqVO);

    /**
     * 更新文章
     *
     * @param updateReqVO 更新信息
     */
    void updateArticle(@Valid ArticleUpdateReqVO updateReqVO);

    /**
     * 删除文章
     *
     * @param id 编号
     */
    void deleteArticle(Long id);

    /**
     * 获得文章
     *
     * @param id 编号
     * @return 文章
     */
    ArticleDO getArticle(Long id);

    /**
     * 获得文章列表
     *
     * @param ids 编号
     * @return 文章列表
     */
    List<ArticleDO> getArticleList(Collection<Long> ids);

    /**
     * 获得文章分页
     *
     * @param pageReqVO 分页查询
     * @return 文章分页
     */
    PageResult<ArticleDO> getArticlePage(ArticlePageReqVO pageReqVO);

    /**
     * 获得文章列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 文章列表
     */
    List<ArticleDO> getArticleList(ArticleExportReqVO exportReqVO);

}
