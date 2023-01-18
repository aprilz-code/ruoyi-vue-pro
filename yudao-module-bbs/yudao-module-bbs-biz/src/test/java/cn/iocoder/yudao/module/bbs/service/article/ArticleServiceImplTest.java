package cn.iocoder.yudao.module.bbs.service.article;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.admin.article.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.article.ArticleDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.article.ArticleMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link ArticleServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ArticleServiceImpl.class)
public class ArticleServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ArticleServiceImpl articleService;

    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void testCreateArticle_success() {
        // 准备参数
        ArticleCreateReqVO reqVO = randomPojo(ArticleCreateReqVO.class);

        // 调用
        Long articleId = articleService.createArticle(reqVO);
        // 断言
        assertNotNull(articleId);
        // 校验记录的属性是否正确
        ArticleDO article = articleMapper.selectById(articleId);
        assertPojoEquals(reqVO, article);
    }

    @Test
    public void testUpdateArticle_success() {
        // mock 数据
        ArticleDO dbArticle = randomPojo(ArticleDO.class);
        articleMapper.insert(dbArticle);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ArticleUpdateReqVO reqVO = randomPojo(ArticleUpdateReqVO.class, o -> {
            o.setId(dbArticle.getId()); // 设置更新的 ID
        });

        // 调用
        articleService.updateArticle(reqVO);
        // 校验是否更新正确
        ArticleDO article = articleMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, article);
    }

    @Test
    public void testUpdateArticle_notExists() {
        // 准备参数
        ArticleUpdateReqVO reqVO = randomPojo(ArticleUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> articleService.updateArticle(reqVO), ARTICLE_NOT_EXISTS);
    }

    @Test
    public void testDeleteArticle_success() {
        // mock 数据
        ArticleDO dbArticle = randomPojo(ArticleDO.class);
        articleMapper.insert(dbArticle);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbArticle.getId();

        // 调用
        articleService.deleteArticle(id);
       // 校验数据不存在了
       assertNull(articleMapper.selectById(id));
    }

    @Test
    public void testDeleteArticle_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> articleService.deleteArticle(id), ARTICLE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetArticlePage() {
       // mock 数据
       ArticleDO dbArticle = randomPojo(ArticleDO.class, o -> { // 等会查询到
           o.setTitle(null);
           o.setThumb(null);
           o.setSummary(null);
           o.setContent(null);
           o.setTagIds(null);
           o.setIsOriginal(null);
           o.setArticlesPart(null);
           o.setClassifyId(null);
           o.setIsTop(null);
           o.setLevel(null);
           o.setOpenComment(null);
           o.setType(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       articleMapper.insert(dbArticle);
       // 测试 title 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setTitle(null)));
       // 测试 thumb 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setThumb(null)));
       // 测试 summary 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setSummary(null)));
       // 测试 content 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setContent(null)));
       // 测试 tagIds 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setTagIds(null)));
       // 测试 isOriginal 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setIsOriginal(null)));
       // 测试 articlesPart 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setArticlesPart(null)));
       // 测试 classifyId 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setClassifyId(null)));
       // 测试 isTop 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setIsTop(null)));
       // 测试 level 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setLevel(null)));
       // 测试 openComment 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setOpenComment(null)));
       // 测试 type 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setType(null)));
       // 测试 status 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setCreateTime(null)));
       // 准备参数
       ArticlePageReqVO reqVO = new ArticlePageReqVO();
       reqVO.setTitle(null);
       reqVO.setThumb(null);
       reqVO.setSummary(null);
       reqVO.setContent(null);
       reqVO.setTagIds(null);
       reqVO.setIsOriginal(null);
       reqVO.setArticlesPart(null);
       reqVO.setClassifyId(null);
       reqVO.setIsTop(null);
       reqVO.setLevel(null);
       reqVO.setOpenComment(null);
       reqVO.setType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<ArticleDO> pageResult = articleService.getArticlePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbArticle, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetArticleList() {
       // mock 数据
       ArticleDO dbArticle = randomPojo(ArticleDO.class, o -> { // 等会查询到
           o.setTitle(null);
           o.setThumb(null);
           o.setSummary(null);
           o.setContent(null);
           o.setTagIds(null);
           o.setIsOriginal(null);
           o.setArticlesPart(null);
           o.setClassifyId(null);
           o.setIsTop(null);
           o.setLevel(null);
           o.setOpenComment(null);
           o.setType(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       articleMapper.insert(dbArticle);
       // 测试 title 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setTitle(null)));
       // 测试 thumb 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setThumb(null)));
       // 测试 summary 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setSummary(null)));
       // 测试 content 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setContent(null)));
       // 测试 tagIds 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setTagIds(null)));
       // 测试 isOriginal 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setIsOriginal(null)));
       // 测试 articlesPart 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setArticlesPart(null)));
       // 测试 classifyId 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setClassifyId(null)));
       // 测试 isTop 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setIsTop(null)));
       // 测试 level 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setLevel(null)));
       // 测试 openComment 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setOpenComment(null)));
       // 测试 type 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setType(null)));
       // 测试 status 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       articleMapper.insert(cloneIgnoreId(dbArticle, o -> o.setCreateTime(null)));
       // 准备参数
       ArticleExportReqVO reqVO = new ArticleExportReqVO();
       reqVO.setTitle(null);
       reqVO.setThumb(null);
       reqVO.setSummary(null);
       reqVO.setContent(null);
       reqVO.setTagIds(null);
       reqVO.setIsOriginal(null);
       reqVO.setArticlesPart(null);
       reqVO.setClassifyId(null);
       reqVO.setIsTop(null);
       reqVO.setLevel(null);
       reqVO.setOpenComment(null);
       reqVO.setType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<ArticleDO> list = articleService.getArticleList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbArticle, list.get(0));
    }

}
