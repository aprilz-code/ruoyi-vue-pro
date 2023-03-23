package cn.iocoder.yudao.module.bbs.convert.msgcontent;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.msgcontent.MsgContentDO;

/**
 * 私聊消息内容 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MsgContentConvert {

    MsgContentConvert INSTANCE = Mappers.getMapper(MsgContentConvert.class);

    MsgContentDO convert(MsgContentCreateReqVO bean);

    MsgContentDO convert(MsgContentUpdateReqVO bean);

    MsgContentRespVO convert(MsgContentDO bean);

    List<MsgContentRespVO> convertList(List<MsgContentDO> list);

    PageResult<MsgContentRespVO> convertPage(PageResult<MsgContentDO> page);

    List<MsgContentExcelVO> convertList02(List<MsgContentDO> list);

}
