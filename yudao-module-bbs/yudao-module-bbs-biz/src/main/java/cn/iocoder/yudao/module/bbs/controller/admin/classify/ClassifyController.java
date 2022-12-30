package cn.iocoder.yudao.module.bbs.controller.admin.classify;

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

import cn.iocoder.yudao.module.bbs.controller.admin.classify.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.classify.ClassifyDO;
import cn.iocoder.yudao.module.bbs.convert.classify.ClassifyConvert;
import cn.iocoder.yudao.module.bbs.service.classify.ClassifyService;

@Api(tags = "管理后台 - 分类")
@RestController
@RequestMapping("/bbs/classify")
@Validated
public class ClassifyController {

    @Resource
    private ClassifyService classifyService;

    @PostMapping("/create")
    @ApiOperation("创建分类")
    @PreAuthorize("@ss.hasPermission('bbs:classify:create')")
    public CommonResult<Long> createClassify(@Valid @RequestBody ClassifyCreateReqVO createReqVO) {
        return success(classifyService.createClassify(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新分类")
    @PreAuthorize("@ss.hasPermission('bbs:classify:update')")
    public CommonResult<Boolean> updateClassify(@Valid @RequestBody ClassifyUpdateReqVO updateReqVO) {
        classifyService.updateClassify(updateReqVO);
        return success(true);
    }

    @PutMapping("/topClassify")
    @ApiOperation("置顶分类")
    @PreAuthorize("@ss.hasPermission('bbs:classify:update')")
    public CommonResult<Boolean> topClassify(@RequestParam("id") Long id) {
        classifyService.topClassify(id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bbs:classify:delete')")
    public CommonResult<Boolean> deleteClassify(@RequestParam("id") Long id) {
        classifyService.deleteClassify(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得分类")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermission('bbs:classify:query')")
    public CommonResult<ClassifyRespVO> getClassify(@RequestParam("id") Long id) {
        ClassifyDO classify = classifyService.getClassify(id);
        return success(ClassifyConvert.INSTANCE.convert(classify));
    }

    @GetMapping("/list")
    @ApiOperation("获得分类列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('bbs:classify:query')")
    public CommonResult<List<ClassifyRespVO>> getClassifyList(@RequestParam("ids") Collection<Long> ids) {
        List<ClassifyDO> list = classifyService.getClassifyList(ids);
        return success(ClassifyConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得分类分页")
    @PreAuthorize("@ss.hasPermission('bbs:classify:query')")
    public CommonResult<PageResult<ClassifyRespVO>> getClassifyPage(@Valid ClassifyPageReqVO pageVO) {
        PageResult<ClassifyDO> pageResult = classifyService.getClassifyPage(pageVO);
        return success(ClassifyConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出分类 Excel")
    @PreAuthorize("@ss.hasPermission('bbs:classify:export')")
    @OperateLog(type = EXPORT)
    public void exportClassifyExcel(@Valid ClassifyExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ClassifyDO> list = classifyService.getClassifyList(exportReqVO);
        // 导出 Excel
        List<ClassifyExcelVO> datas = ClassifyConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "分类.xls", "数据", ClassifyExcelVO.class, datas);
    }

}
