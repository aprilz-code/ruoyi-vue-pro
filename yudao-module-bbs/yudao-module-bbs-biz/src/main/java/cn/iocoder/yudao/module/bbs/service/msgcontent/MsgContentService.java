package cn.iocoder.yudao.module.bbs.service.msgcontent;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.msgcontent.MsgContentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 私聊消息内容 Service 接口
 *
 * @author 芋道源码
 */
public interface MsgContentService {

    /**
     * 创建私聊消息内容
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMsgContent(@Valid MsgContentCreateReqVO createReqVO);

    /**
     * 更新私聊消息内容
     *
     * @param updateReqVO 更新信息
     */
    void updateMsgContent(@Valid MsgContentUpdateReqVO updateReqVO);

    /**
     * 删除私聊消息内容
     *
     * @param id 编号
     */
    void deleteMsgContent(Long id);

    /**
     * 获得私聊消息内容
     *
     * @param id 编号
     * @return 私聊消息内容
     */
    MsgContentDO getMsgContent(Long id);

    /**
     * 获得私聊消息内容列表
     *
     * @param ids 编号
     * @return 私聊消息内容列表
     */
    List<MsgContentDO> getMsgContentList(Collection<Long> ids);

    /**
     * 获得私聊消息内容分页
     *
     * @param pageReqVO 分页查询
     * @return 私聊消息内容分页
     */
    PageResult<MsgContentDO> getMsgContentPage(MsgContentPageReqVO pageReqVO);

    /**
     * 获得私聊消息内容列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 私聊消息内容列表
     */
    List<MsgContentDO> getMsgContentList(MsgContentExportReqVO exportReqVO);

}
