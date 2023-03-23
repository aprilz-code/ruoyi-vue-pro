package cn.iocoder.yudao.module.bbs.dal.mysql.messagetype;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bbs.dal.dataobject.messagetype.MessageTypeDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo.*;

/**
 * 消息类型 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MessageTypeMapper extends BaseMapperX<MessageTypeDO> {

    default PageResult<MessageTypeDO> selectPage(MessageTypePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MessageTypeDO>()
                .eqIfPresent(MessageTypeDO::getTypeCode, reqVO.getTypeCode())
                .likeIfPresent(MessageTypeDO::getTypeName, reqVO.getTypeName())
                .betweenIfPresent(MessageTypeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MessageTypeDO::getId));
    }

    default List<MessageTypeDO> selectList(MessageTypeExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MessageTypeDO>()
                .eqIfPresent(MessageTypeDO::getTypeCode, reqVO.getTypeCode())
                .likeIfPresent(MessageTypeDO::getTypeName, reqVO.getTypeName())
                .betweenIfPresent(MessageTypeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MessageTypeDO::getId));
    }

}
