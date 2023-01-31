package cn.iocoder.yudao.module.bbs.controller.app.milog;

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

import cn.iocoder.yudao.module.bbs.controller.app.milog.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.milog.MiLogDO;
import cn.iocoder.yudao.module.bbs.convert.milog.MiLogConvert;
import cn.iocoder.yudao.module.bbs.service.milog.MiLogService;

@Api(tags = "用户 APP - 米日志")
@RestController
@RequestMapping("/bbs/mi-log")
@Validated
public class AppMiLogController {

    @Resource
    private MiLogService miLogService;

    @PostMapping("/create")
    @ApiOperation("创建米日志")

    public CommonResult<Long> createMiLog(@Valid @RequestBody AppMiLogCreateReqVO createReqVO) {
        return success(miLogService.createMiLog(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新米日志")

    public CommonResult<Boolean> updateMiLog(@Valid @RequestBody AppMiLogUpdateReqVO updateReqVO) {
        miLogService.updateMiLog(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除米日志")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)

    public CommonResult<Boolean> deleteMiLog(@RequestParam("id") Long id) {
        miLogService.deleteMiLog(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得米日志")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)

    public CommonResult<AppMiLogRespVO> getMiLog(@RequestParam("id") Long id) {
        MiLogDO miLog = miLogService.getMiLog(id);
        return success(MiLogConvert.INSTANCE.convert(miLog));
    }

    @GetMapping("/list")
    @ApiOperation("获得米日志列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)

    public CommonResult<List<AppMiLogRespVO>> getMiLogList(@RequestParam("ids") Collection<Long> ids) {
        List<MiLogDO> list = miLogService.getMiLogList(ids);
        return success(MiLogConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得米日志分页")

    public CommonResult<PageResult<AppMiLogRespVO>> getMiLogPage(@Valid AppMiLogPageReqVO pageVO) {
        PageResult<MiLogDO> pageResult = miLogService.getMiLogPage(pageVO);
        return success(MiLogConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出米日志 Excel")

    @OperateLog(type = EXPORT)
    public void exportMiLogExcel(@Valid AppMiLogExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MiLogDO> list = miLogService.getMiLogList(exportReqVO);
        // 导出 Excel
        List<AppMiLogExcelVO> datas = MiLogConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "米日志.xls", "数据", AppMiLogExcelVO.class, datas);
    }

}
