package cn.iocoder.yudao.module.bbs.dal.mysql.msgcontent;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bbs.dal.dataobject.msgcontent.MsgContentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo.*;

/**
 * 私聊消息内容 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MsgContentMapper extends BaseMapperX<MsgContentDO> {

    default PageResult<MsgContentDO> selectPage(MsgContentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MsgContentDO>()
                .eqIfPresent(MsgContentDO::getPrivateChatId, reqVO.getPrivateChatId())
                .eqIfPresent(MsgContentDO::getFromId, reqVO.getFromId())
                .likeIfPresent(MsgContentDO::getFromName, reqVO.getFromName())
                .eqIfPresent(MsgContentDO::getFromProfile, reqVO.getFromProfile())
                .eqIfPresent(MsgContentDO::getContent, reqVO.getContent())
                .eqIfPresent(MsgContentDO::getMessageType, reqVO.getMessageType())
                .betweenIfPresent(MsgContentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MsgContentDO::getId));
    }

    default List<MsgContentDO> selectList(MsgContentExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MsgContentDO>()
                .eqIfPresent(MsgContentDO::getPrivateChatId, reqVO.getPrivateChatId())
                .eqIfPresent(MsgContentDO::getFromId, reqVO.getFromId())
                .likeIfPresent(MsgContentDO::getFromName, reqVO.getFromName())
                .eqIfPresent(MsgContentDO::getFromProfile, reqVO.getFromProfile())
                .eqIfPresent(MsgContentDO::getContent, reqVO.getContent())
                .eqIfPresent(MsgContentDO::getMessageType, reqVO.getMessageType())
                .betweenIfPresent(MsgContentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MsgContentDO::getId));
    }

}
