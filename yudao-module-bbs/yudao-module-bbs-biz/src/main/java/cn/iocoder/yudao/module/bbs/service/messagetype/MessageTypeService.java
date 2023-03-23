package cn.iocoder.yudao.module.bbs.service.messagetype;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.messagetype.MessageTypeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 消息类型 Service 接口
 *
 * @author 芋道源码
 */
public interface MessageTypeService {

    /**
     * 创建消息类型
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMessageType(@Valid MessageTypeCreateReqVO createReqVO);

    /**
     * 更新消息类型
     *
     * @param updateReqVO 更新信息
     */
    void updateMessageType(@Valid MessageTypeUpdateReqVO updateReqVO);

    /**
     * 删除消息类型
     *
     * @param id 编号
     */
    void deleteMessageType(Long id);

    /**
     * 获得消息类型
     *
     * @param id 编号
     * @return 消息类型
     */
    MessageTypeDO getMessageType(Long id);

    /**
     * 获得消息类型列表
     *
     * @param ids 编号
     * @return 消息类型列表
     */
    List<MessageTypeDO> getMessageTypeList(Collection<Long> ids);

    /**
     * 获得消息类型分页
     *
     * @param pageReqVO 分页查询
     * @return 消息类型分页
     */
    PageResult<MessageTypeDO> getMessageTypePage(MessageTypePageReqVO pageReqVO);

    /**
     * 获得消息类型列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 消息类型列表
     */
    List<MessageTypeDO> getMessageTypeList(MessageTypeExportReqVO exportReqVO);

}
