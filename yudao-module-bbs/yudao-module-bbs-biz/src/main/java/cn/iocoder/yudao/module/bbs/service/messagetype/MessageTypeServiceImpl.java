package cn.iocoder.yudao.module.bbs.service.messagetype;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.messagetype.MessageTypeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.bbs.convert.messagetype.MessageTypeConvert;
import cn.iocoder.yudao.module.bbs.dal.mysql.messagetype.MessageTypeMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;

/**
 * 消息类型 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MessageTypeServiceImpl implements MessageTypeService {

    @Resource
    private MessageTypeMapper messageTypeMapper;

    @Override
    public Long createMessageType(MessageTypeCreateReqVO createReqVO) {
        // 插入
        MessageTypeDO messageType = MessageTypeConvert.INSTANCE.convert(createReqVO);
        messageTypeMapper.insert(messageType);
        // 返回
        return messageType.getId();
    }

    @Override
    public void updateMessageType(MessageTypeUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMessageTypeExists(updateReqVO.getId());
        // 更新
        MessageTypeDO updateObj = MessageTypeConvert.INSTANCE.convert(updateReqVO);
        messageTypeMapper.updateById(updateObj);
    }

    @Override
    public void deleteMessageType(Long id) {
        // 校验存在
        this.validateMessageTypeExists(id);
        // 删除
        messageTypeMapper.deleteById(id);
    }

    private void validateMessageTypeExists(Long id) {
        if (messageTypeMapper.selectById(id) == null) {
            throw exception(MESSAGE_TYPE_NOT_EXISTS);
        }
    }

    @Override
    public MessageTypeDO getMessageType(Long id) {
        return messageTypeMapper.selectById(id);
    }

    @Override
    public List<MessageTypeDO> getMessageTypeList(Collection<Long> ids) {
        return messageTypeMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MessageTypeDO> getMessageTypePage(MessageTypePageReqVO pageReqVO) {
        return messageTypeMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MessageTypeDO> getMessageTypeList(MessageTypeExportReqVO exportReqVO) {
        return messageTypeMapper.selectList(exportReqVO);
    }

}
