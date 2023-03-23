package cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent;

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

import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.groupmsgcontent.GroupMsgContentDO;
import cn.iocoder.yudao.module.bbs.convert.groupmsgcontent.GroupMsgContentConvert;
import cn.iocoder.yudao.module.bbs.service.groupmsgcontent.GroupMsgContentService;

@Api(tags = "管理后台 - 群聊消息内容")
@RestController
@RequestMapping("/bbs/group-msg-content")
@Validated
public class GroupMsgContentController {

    @Resource
    private GroupMsgContentService groupMsgContentService;

    @PostMapping("/create")
    @ApiOperation("创建群聊消息内容")
    public CommonResult<Long> createGroupMsgContent(@Valid @RequestBody GroupMsgContentCreateReqVO createReqVO) {
        return success(groupMsgContentService.createGroupMsgContent(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新群聊消息内容")
    public CommonResult<Boolean> updateGroupMsgContent(@Valid @RequestBody GroupMsgContentUpdateReqVO updateReqVO) {
        groupMsgContentService.updateGroupMsgContent(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除群聊消息内容")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = Long.class)
    public CommonResult<Boolean> deleteGroupMsgContent(@RequestParam("id") Long id) {
        groupMsgContentService.deleteGroupMsgContent(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得群聊消息内容")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<GroupMsgContentRespVO> getGroupMsgContent(@RequestParam("id") Long id) {
        GroupMsgContentDO groupMsgContent = groupMsgContentService.getGroupMsgContent(id);
        return success(GroupMsgContentConvert.INSTANCE.convert(groupMsgContent));
    }

    @GetMapping("/list")
    @ApiOperation("获得群聊消息内容列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    public CommonResult<List<GroupMsgContentRespVO>> getGroupMsgContentList(@RequestParam("ids") Collection<Long> ids) {
        List<GroupMsgContentDO> list = groupMsgContentService.getGroupMsgContentList(ids);
        return success(GroupMsgContentConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得群聊消息内容分页")
    public CommonResult<PageResult<GroupMsgContentRespVO>> getGroupMsgContentPage(@Valid GroupMsgContentPageReqVO pageVO) {
        PageResult<GroupMsgContentDO> pageResult = groupMsgContentService.getGroupMsgContentPage(pageVO);
        return success(GroupMsgContentConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出群聊消息内容 Excel")
    @OperateLog(type = EXPORT)
    public void exportGroupMsgContentExcel(@Valid GroupMsgContentExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<GroupMsgContentDO> list = groupMsgContentService.getGroupMsgContentList(exportReqVO);
        // 导出 Excel
        List<GroupMsgContentExcelVO> datas = GroupMsgContentConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "群聊消息内容.xls", "数据", GroupMsgContentExcelVO.class, datas);
    }

}
