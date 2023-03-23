package cn.iocoder.yudao.module.bbs.controller.app.messagetype;

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

import cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.messagetype.MessageTypeDO;
import cn.iocoder.yudao.module.bbs.convert.messagetype.MessageTypeConvert;
import cn.iocoder.yudao.module.bbs.service.messagetype.MessageTypeService;

@Api(tags = "管理后台 - 消息类型")
@RestController
@RequestMapping("/bbs/message-type")
@Validated
public class MessageTypeController {

    @Resource
    private MessageTypeService messageTypeService;

    @PostMapping("/create")
    @ApiOperation("创建消息类型")
    public CommonResult<Long> createMessageType(@Valid @RequestBody MessageTypeCreateReqVO createReqVO) {
        return success(messageTypeService.createMessageType(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新消息类型")
    public CommonResult<Boolean> updateMessageType(@Valid @RequestBody MessageTypeUpdateReqVO updateReqVO) {
        messageTypeService.updateMessageType(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除消息类型")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    public CommonResult<Boolean> deleteMessageType(@RequestParam("id") Long id) {
        messageTypeService.deleteMessageType(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得消息类型")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<MessageTypeRespVO> getMessageType(@RequestParam("id") Long id) {
        MessageTypeDO messageType = messageTypeService.getMessageType(id);
        return success(MessageTypeConvert.INSTANCE.convert(messageType));
    }

    @GetMapping("/list")
    @ApiOperation("获得消息类型列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    public CommonResult<List<MessageTypeRespVO>> getMessageTypeList(@RequestParam("ids") Collection<Long> ids) {
        List<MessageTypeDO> list = messageTypeService.getMessageTypeList(ids);
        return success(MessageTypeConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得消息类型分页")
    public CommonResult<PageResult<MessageTypeRespVO>> getMessageTypePage(@Valid MessageTypePageReqVO pageVO) {
        PageResult<MessageTypeDO> pageResult = messageTypeService.getMessageTypePage(pageVO);
        return success(MessageTypeConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出消息类型 Excel")
    @OperateLog(type = EXPORT)
    public void exportMessageTypeExcel(@Valid MessageTypeExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MessageTypeDO> list = messageTypeService.getMessageTypeList(exportReqVO);
        // 导出 Excel
        List<MessageTypeExcelVO> datas = MessageTypeConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "消息类型.xls", "数据", MessageTypeExcelVO.class, datas);
    }

}
