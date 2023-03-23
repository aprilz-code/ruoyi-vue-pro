package cn.iocoder.yudao.module.bbs.controller.app.msgcontent;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

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

import cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.msgcontent.MsgContentDO;
import cn.iocoder.yudao.module.bbs.convert.msgcontent.MsgContentConvert;
import cn.iocoder.yudao.module.bbs.service.msgcontent.MsgContentService;

@Api(tags = "管理后台 - 私聊消息内容")
@RestController
@RequestMapping("/bbs/msg-content")
@Validated
public class MsgContentController {

    @Resource
    private MsgContentService msgContentService;

    @PostMapping("/create")
    @ApiOperation("创建私聊消息内容")
    public CommonResult<Long> createMsgContent(@Valid @RequestBody MsgContentCreateReqVO createReqVO) {
        return success(msgContentService.createMsgContent(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新私聊消息内容")
    public CommonResult<Boolean> updateMsgContent(@Valid @RequestBody MsgContentUpdateReqVO updateReqVO) {
        msgContentService.updateMsgContent(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除私聊消息内容")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    public CommonResult<Boolean> deleteMsgContent(@RequestParam("id") Long id) {
        msgContentService.deleteMsgContent(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得私聊消息内容")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<MsgContentRespVO> getMsgContent(@RequestParam("id") Long id) {
        MsgContentDO msgContent = msgContentService.getMsgContent(id);
        return success(MsgContentConvert.INSTANCE.convert(msgContent));
    }

    @GetMapping("/list")
    @ApiOperation("获得私聊消息内容列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    public CommonResult<List<MsgContentRespVO>> getMsgContentList(@RequestParam("ids") Collection<Long> ids) {
        List<MsgContentDO> list = msgContentService.getMsgContentList(ids);
        return success(MsgContentConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得私聊消息内容分页")
    public CommonResult<PageResult<MsgContentRespVO>> getMsgContentPage(@Valid MsgContentPageReqVO pageVO) {
        PageResult<MsgContentDO> pageResult = msgContentService.getMsgContentPage(pageVO);
        return success(MsgContentConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出私聊消息内容 Excel")
    @OperateLog(type = EXPORT)
    public void exportMsgContentExcel(@Valid MsgContentExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MsgContentDO> list = msgContentService.getMsgContentList(exportReqVO);
        // 导出 Excel
        List<MsgContentExcelVO> datas = MsgContentConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "私聊消息内容.xls", "数据", MsgContentExcelVO.class, datas);
    }

}
