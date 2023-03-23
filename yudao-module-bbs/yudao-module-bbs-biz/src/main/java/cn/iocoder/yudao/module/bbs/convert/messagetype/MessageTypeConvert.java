package cn.iocoder.yudao.module.bbs.convert.messagetype;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.messagetype.MessageTypeDO;

/**
 * 消息类型 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MessageTypeConvert {

    MessageTypeConvert INSTANCE = Mappers.getMapper(MessageTypeConvert.class);

    MessageTypeDO convert(MessageTypeCreateReqVO bean);

    MessageTypeDO convert(MessageTypeUpdateReqVO bean);

    MessageTypeRespVO convert(MessageTypeDO bean);

    List<MessageTypeRespVO> convertList(List<MessageTypeDO> list);

    PageResult<MessageTypeRespVO> convertPage(PageResult<MessageTypeDO> page);

    List<MessageTypeExcelVO> convertList02(List<MessageTypeDO> list);

}
