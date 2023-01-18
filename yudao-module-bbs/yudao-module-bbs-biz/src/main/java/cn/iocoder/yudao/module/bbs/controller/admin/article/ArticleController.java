package cn.iocoder.yudao.module.bbs.controller.admin.article;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import cn.iocoder.yudao.module.bbs.controller.admin.article.vo.*;
import cn.iocoder.yudao.module.bbs.convert.article.ArticleConvert;
import cn.iocoder.yudao.module.bbs.dal.dataobject.article.ArticleDO;
import cn.iocoder.yudao.module.bbs.dal.dataobject.tag.TagDO;
import cn.iocoder.yudao.module.bbs.service.article.ArticleService;
import cn.iocoder.yudao.module.bbs.service.tag.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "管理后台 - 文章")
@RestController
@RequestMapping("/bbs/article")
@Validated
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private TagService tagService;

    @PostMapping("/create")
    @ApiOperation("创建文章")
    @PreAuthorize("@ss.hasPermission('bbs:article:create')")
    public CommonResult<Long> createArticle(@Valid @RequestBody ArticleCreateReqVO createReqVO) {
        return success(articleService.createArticle(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新文章")
    @PreAuthorize("@ss.hasPermission('bbs:article:update')")
    public CommonResult<Boolean> updateArticle(@Valid @RequestBody ArticleUpdateReqVO updateReqVO) {
        articleService.updateArticle(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除文章")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bbs:article:delete')")
    public CommonResult<Boolean> deleteArticle(@RequestParam("id") Long id) {
        articleService.deleteArticle(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得文章")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bbs:article:query')")
    public CommonResult<ArticleRespVO> getArticle(@RequestParam("id") Long id) {
        ArticleDO article = articleService.getArticle(id);
        return success(ArticleConvert.INSTANCE.convert(article));
    }

    @GetMapping("/list")
    @ApiOperation("获得文章列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bbs:article:query')")
    public CommonResult<List<ArticleRespVO>> getArticleList(@RequestParam("ids") Collection<Long> ids) {
        List<ArticleDO> list = articleService.getArticleList(ids);
        return success(ArticleConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得文章分页")
    @PreAuthorize("@ss.hasPermission('bbs:article:query')")
    public CommonResult<PageResult<ArticleRespVO>> getArticlePage(@Valid ArticlePageReqVO pageVO) {
        PageResult<ArticleDO> pageResult = articleService.getArticlePage(pageVO);
        PageResult<ArticleRespVO> result = ArticleConvert.INSTANCE.convertPage(pageResult);
        List<TagDO> tagList = tagService.selectList();
        if (CollUtil.isEmpty(tagList)) {
            return success(result);
        }

        result.getList().parallelStream().forEach(re -> {
            List<Long> tagIds = re.getTagIds();
            re.setTagNames(tagList.stream().filter(tag -> tagIds.contains(tag.getId())).map(TagDO::getContent).collect(Collectors.toList()));
        });
        return success(result);
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出文章 Excel")
    @PreAuthorize("@ss.hasPermission('bbs:article:export')")
    @OperateLog(type = EXPORT)
    public void exportArticleExcel(@Valid ArticleExportReqVO exportReqVO,
                                   HttpServletResponse response) throws IOException {
        List<ArticleDO> list = articleService.getArticleList(exportReqVO);
        // 导出 Excel
        List<ArticleExcelVO> datas = ArticleConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "文章.xls", "数据", ArticleExcelVO.class, datas);
    }

}
