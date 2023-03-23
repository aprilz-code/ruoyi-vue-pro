package cn.iocoder.yudao.module.bbs.service.groupmsgcontent;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.groupmsgcontent.GroupMsgContentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 群聊消息内容 Service 接口
 *
 * @author 芋道源码
 */
public interface GroupMsgContentService {

    /**
     * 创建群聊消息内容
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createGroupMsgContent(@Valid GroupMsgContentCreateReqVO createReqVO);

    /**
     * 更新群聊消息内容
     *
     * @param updateReqVO 更新信息
     */
    void updateGroupMsgContent(@Valid GroupMsgContentUpdateReqVO updateReqVO);

    /**
     * 删除群聊消息内容
     *
     * @param id 编号
     */
    void deleteGroupMsgContent(Long id);

    /**
     * 获得群聊消息内容
     *
     * @param id 编号
     * @return 群聊消息内容
     */
    GroupMsgContentDO getGroupMsgContent(Long id);

    /**
     * 获得群聊消息内容列表
     *
     * @param ids 编号
     * @return 群聊消息内容列表
     */
    List<GroupMsgContentDO> getGroupMsgContentList(Collection<Long> ids);

    /**
     * 获得群聊消息内容分页
     *
     * @param pageReqVO 分页查询
     * @return 群聊消息内容分页
     */
    PageResult<GroupMsgContentDO> getGroupMsgContentPage(GroupMsgContentPageReqVO pageReqVO);

    /**
     * 获得群聊消息内容列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 群聊消息内容列表
     */
    List<GroupMsgContentDO> getGroupMsgContentList(GroupMsgContentExportReqVO exportReqVO);

}
