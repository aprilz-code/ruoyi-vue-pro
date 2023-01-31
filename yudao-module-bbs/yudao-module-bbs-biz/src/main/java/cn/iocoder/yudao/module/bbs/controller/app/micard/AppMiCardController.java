package cn.iocoder.yudao.module.bbs.controller.app.micard;

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

import cn.iocoder.yudao.module.bbs.controller.app.micard.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.micard.MiCardDO;
import cn.iocoder.yudao.module.bbs.convert.micard.MiCardConvert;
import cn.iocoder.yudao.module.bbs.service.micard.MiCardService;

@Api(tags = "用户 APP - 米卡密")
@RestController
@RequestMapping("/bbs/mi-card")
@Validated
public class AppMiCardController {

    @Resource
    private MiCardService miCardService;

    @PostMapping("/create")
    @ApiOperation("创建米卡密")

    public CommonResult<Long> createMiCard(@Valid @RequestBody AppMiCardCreateReqVO createReqVO) {
        return success(miCardService.createMiCard(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新米卡密")

    public CommonResult<Boolean> updateMiCard(@Valid @RequestBody AppMiCardUpdateReqVO updateReqVO) {
        miCardService.updateMiCard(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除米卡密")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)

    public CommonResult<Boolean> deleteMiCard(@RequestParam("id") Long id) {
        miCardService.deleteMiCard(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得米卡密")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)

    public CommonResult<AppMiCardRespVO> getMiCard(@RequestParam("id") Long id) {
        MiCardDO miCard = miCardService.getMiCard(id);
        return success(MiCardConvert.INSTANCE.convert(miCard));
    }

    @GetMapping("/list")
    @ApiOperation("获得米卡密列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)

    public CommonResult<List<AppMiCardRespVO>> getMiCardList(@RequestParam("ids") Collection<Long> ids) {
        List<MiCardDO> list = miCardService.getMiCardList(ids);
        return success(MiCardConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得米卡密分页")

    public CommonResult<PageResult<AppMiCardRespVO>> getMiCardPage(@Valid AppMiCardPageReqVO pageVO) {
        PageResult<MiCardDO> pageResult = miCardService.getMiCardPage(pageVO);
        return success(MiCardConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出米卡密 Excel")

    @OperateLog(type = EXPORT)
    public void exportMiCardExcel(@Valid AppMiCardExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MiCardDO> list = miCardService.getMiCardList(exportReqVO);
        // 导出 Excel
        List<AppMiCardExcelVO> datas = MiCardConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "米卡密.xls", "数据", AppMiCardExcelVO.class, datas);
    }

}
