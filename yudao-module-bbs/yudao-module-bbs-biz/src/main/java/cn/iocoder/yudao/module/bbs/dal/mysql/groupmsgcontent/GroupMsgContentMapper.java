package cn.iocoder.yudao.module.bbs.dal.mysql.groupmsgcontent;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bbs.dal.dataobject.groupmsgcontent.GroupMsgContentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.*;

/**
 * 群聊消息内容 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GroupMsgContentMapper extends BaseMapperX<GroupMsgContentDO> {

    default PageResult<GroupMsgContentDO> selectPage(GroupMsgContentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GroupMsgContentDO>()
                .eqIfPresent(GroupMsgContentDO::getGroupId, reqVO.getGroupId())
                .eqIfPresent(GroupMsgContentDO::getFromId, reqVO.getFromId())
                .likeIfPresent(GroupMsgContentDO::getFromName, reqVO.getFromName())
                .eqIfPresent(GroupMsgContentDO::getFromProfile, reqVO.getFromProfile())
                .eqIfPresent(GroupMsgContentDO::getContent, reqVO.getContent())
                .eqIfPresent(GroupMsgContentDO::getMessageType, reqVO.getMessageType())
                .betweenIfPresent(GroupMsgContentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GroupMsgContentDO::getId));
    }

    default List<GroupMsgContentDO> selectList(GroupMsgContentExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<GroupMsgContentDO>()
                .eqIfPresent(GroupMsgContentDO::getGroupId, reqVO.getGroupId())
                .eqIfPresent(GroupMsgContentDO::getFromId, reqVO.getFromId())
                .likeIfPresent(GroupMsgContentDO::getFromName, reqVO.getFromName())
                .eqIfPresent(GroupMsgContentDO::getFromProfile, reqVO.getFromProfile())
                .eqIfPresent(GroupMsgContentDO::getContent, reqVO.getContent())
                .eqIfPresent(GroupMsgContentDO::getMessageType, reqVO.getMessageType())
                .betweenIfPresent(GroupMsgContentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GroupMsgContentDO::getId));
    }

}
