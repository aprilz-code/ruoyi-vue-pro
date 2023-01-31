package cn.iocoder.yudao.module.bbs.controller.app.mijob;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

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

import cn.iocoder.yudao.module.bbs.controller.app.mijob.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.mijob.MiJobDO;
import cn.iocoder.yudao.module.bbs.convert.mijob.MiJobConvert;
import cn.iocoder.yudao.module.bbs.service.mijob.MiJobService;

@Api(tags = "用户 APP - 米job")
@RestController
@RequestMapping("/bbs/mi-job")
@Validated
public class AppMiJobController {

    @Resource
    private MiJobService miJobService;

    @PostMapping("/create")
    @ApiOperation("创建米job")

    public CommonResult<Long> createMiJob(@Valid @RequestBody AppMiJobCreateReqVO createReqVO) {
        return success(miJobService.createMiJob(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新米job")

    public CommonResult<Boolean> updateMiJob(@Valid @RequestBody AppMiJobUpdateReqVO updateReqVO) {
        miJobService.updateMiJob(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除米job")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)

    public CommonResult<Boolean> deleteMiJob(@RequestParam("id") Long id) {
        miJobService.deleteMiJob(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得米job")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)

    public CommonResult<AppMiJobRespVO> getMiJob(@RequestParam("id") Long id) {
        MiJobDO miJob = miJobService.getMiJob(id);
        return success(MiJobConvert.INSTANCE.convert(miJob));
    }

    @GetMapping("/list")
    @ApiOperation("获得米job列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)

    public CommonResult<List<AppMiJobRespVO>> getMiJobList(@RequestParam("ids") Collection<Long> ids) {
        List<MiJobDO> list = miJobService.getMiJobList(ids);
        return success(MiJobConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得米job分页")

    public CommonResult<PageResult<AppMiJobRespVO>> getMiJobPage(@Valid AppMiJobPageReqVO pageVO) {
        PageResult<MiJobDO> pageResult = miJobService.getMiJobPage(pageVO);
        return success(MiJobConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出米job Excel")

    @OperateLog(type = EXPORT)
    public void exportMiJobExcel(@Valid AppMiJobExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MiJobDO> list = miJobService.getMiJobList(exportReqVO);
        // 导出 Excel
        List<AppMiJobExcelVO> datas = MiJobConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "米job.xls", "数据", AppMiJobExcelVO.class, datas);
    }

}
