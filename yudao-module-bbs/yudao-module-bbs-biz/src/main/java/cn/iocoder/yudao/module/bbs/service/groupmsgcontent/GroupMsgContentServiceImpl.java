package cn.iocoder.yudao.module.bbs.service.groupmsgcontent;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.GroupMsgContentCreateReqVO;
import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.GroupMsgContentExportReqVO;
import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.GroupMsgContentPageReqVO;
import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.GroupMsgContentUpdateReqVO;
import cn.iocoder.yudao.module.bbs.convert.groupmsgcontent.GroupMsgContentConvert;
import cn.iocoder.yudao.module.bbs.dal.dataobject.groupmsgcontent.GroupMsgContentDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.groupmsgcontent.GroupMsgContentMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.GROUP_MSG_CONTENT_NOT_EXISTS;

/**
 * 群聊消息内容 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GroupMsgContentServiceImpl implements GroupMsgContentService {

    @Resource
    private GroupMsgContentMapper groupMsgContentMapper;

    @Override
    public Long createGroupMsgContent(GroupMsgContentCreateReqVO createReqVO) {
        // 插入
        GroupMsgContentDO groupMsgContent = GroupMsgContentConvert.INSTANCE.convert(createReqVO);
        groupMsgContentMapper.insert(groupMsgContent);
        // 返回
        return groupMsgContent.getId();
    }

    @Override
    public void updateGroupMsgContent(GroupMsgContentUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateGroupMsgContentExists(updateReqVO.getId());
        // 更新
        GroupMsgContentDO updateObj = GroupMsgContentConvert.INSTANCE.convert(updateReqVO);
        groupMsgContentMapper.updateById(updateObj);
    }

    @Override
    public void deleteGroupMsgContent(Long id) {
        // 校验存在
        this.validateGroupMsgContentExists(id);
        // 删除
        groupMsgContentMapper.deleteById(id);
    }

    private void validateGroupMsgContentExists(Long id) {
        if (groupMsgContentMapper.selectById(id) == null) {
            throw exception(GROUP_MSG_CONTENT_NOT_EXISTS);
        }
    }

    @Override
    public GroupMsgContentDO getGroupMsgContent(Long id) {
        return groupMsgContentMapper.selectById(id);
    }

    @Override
    public List<GroupMsgContentDO> getGroupMsgContentList(Collection<Long> ids) {
        return groupMsgContentMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<GroupMsgContentDO> getGroupMsgContentPage(GroupMsgContentPageReqVO pageReqVO) {
        return groupMsgContentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GroupMsgContentDO> getGroupMsgContentList(GroupMsgContentExportReqVO exportReqVO) {
        return groupMsgContentMapper.selectList(exportReqVO);
    }

}
