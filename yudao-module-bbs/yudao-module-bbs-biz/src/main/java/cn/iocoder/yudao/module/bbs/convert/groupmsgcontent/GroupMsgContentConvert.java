package cn.iocoder.yudao.module.bbs.convert.groupmsgcontent;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.groupmsgcontent.GroupMsgContentDO;

/**
 * 群聊消息内容 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface GroupMsgContentConvert {

    GroupMsgContentConvert INSTANCE = Mappers.getMapper(GroupMsgContentConvert.class);

    GroupMsgContentDO convert(GroupMsgContentCreateReqVO bean);

    GroupMsgContentDO convert(GroupMsgContentUpdateReqVO bean);

    GroupMsgContentRespVO convert(GroupMsgContentDO bean);

    List<GroupMsgContentRespVO> convertList(List<GroupMsgContentDO> list);

    PageResult<GroupMsgContentRespVO> convertPage(PageResult<GroupMsgContentDO> page);

    List<GroupMsgContentExcelVO> convertList02(List<GroupMsgContentDO> list);

}
