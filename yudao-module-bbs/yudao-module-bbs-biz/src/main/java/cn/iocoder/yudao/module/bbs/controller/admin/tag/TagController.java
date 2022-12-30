package cn.iocoder.yudao.module.bbs.controller.admin.tag;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.bbs.controller.admin.tag.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.tag.TagDO;
import cn.iocoder.yudao.module.bbs.convert.tag.TagConvert;
import cn.iocoder.yudao.module.bbs.service.tag.TagService;

@Api(tags = "管理后台 - 标签")
@RestController
@RequestMapping("/bbs/tag")
@Validated
public class TagController {

    @Resource
    private TagService tagService;

    @PostMapping("/create")
    @ApiOperation("创建标签")
    @PreAuthorize("@ss.hasPermission('bbs:tag:create')")
    public CommonResult<Long> createTag(@Valid @RequestBody TagCreateReqVO createReqVO) {
        return success(tagService.createTag(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新标签")
    @PreAuthorize("@ss.hasPermission('bbs:tag:update')")
    public CommonResult<Boolean> updateTag(@Valid @RequestBody TagUpdateReqVO updateReqVO) {
        tagService.updateTag(updateReqVO);
        return success(true);
    }

    @PutMapping("/topTag")
    @ApiOperation("置顶标签")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bbs:tag:update')")
    public CommonResult<Boolean> topTag(@RequestParam("id") Long id) {
        tagService.topTag(id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除标签")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bbs:tag:delete')")
    public CommonResult<Boolean> deleteTag(@RequestParam("id") Long id) {
        tagService.deleteTag(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得标签")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bbs:tag:query')")
    public CommonResult<TagRespVO> getTag(@RequestParam("id") Long id) {
        TagDO tag = tagService.getTag(id);
        return success(TagConvert.INSTANCE.convert(tag));
    }

    @GetMapping("/list")
    @ApiOperation("获得标签列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bbs:tag:query')")
    public CommonResult<List<TagRespVO>> getTagList(@RequestParam("ids") Collection<Long> ids) {
        List<TagDO> list = tagService.getTagList(ids);
        return success(TagConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得标签分页")
    @PreAuthorize("@ss.hasPermission('bbs:tag:query')")
    public CommonResult<PageResult<TagRespVO>> getTagPage(@Valid TagPageReqVO pageVO) {
        PageResult<TagDO> pageResult = tagService.getTagPage(pageVO);
        return success(TagConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出标签 Excel")
    @PreAuthorize("@ss.hasPermission('bbs:tag:export')")
    @OperateLog(type = EXPORT)
    public void exportTagExcel(@Valid TagExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TagDO> list = tagService.getTagList(exportReqVO);
        // 导出 Excel
        List<TagExcelVO> datas = TagConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "标签.xls", "数据", TagExcelVO.class, datas);
    }

}
