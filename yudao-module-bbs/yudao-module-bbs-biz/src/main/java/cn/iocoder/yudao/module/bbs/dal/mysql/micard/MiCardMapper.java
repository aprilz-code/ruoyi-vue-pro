package cn.iocoder.yudao.module.bbs.dal.mysql.micard;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bbs.dal.dataobject.micard.MiCardDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bbs.controller.app.micard.vo.*;

/**
 * 米卡密 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MiCardMapper extends BaseMapperX<MiCardDO> {

    default PageResult<MiCardDO> selectPage(AppMiCardPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MiCardDO>()
                .eqIfPresent(MiCardDO::getCardNo, reqVO.getCardNo())
                .eqIfPresent(MiCardDO::getType, reqVO.getType())
                .eqIfPresent(MiCardDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MiCardDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MiCardDO::getId));
    }

    default List<MiCardDO> selectList(AppMiCardExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MiCardDO>()
                .eqIfPresent(MiCardDO::getCardNo, reqVO.getCardNo())
                .eqIfPresent(MiCardDO::getType, reqVO.getType())
                .eqIfPresent(MiCardDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MiCardDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MiCardDO::getId));
    }

    default MiCardDO selectOne(AppMiCardExportReqVO reqVO) {
        return selectOne(new LambdaQueryWrapperX<MiCardDO>()
                .eqIfPresent(MiCardDO::getCardNo, reqVO.getCardNo())
                .eqIfPresent(MiCardDO::getType, reqVO.getType())
                .eqIfPresent(MiCardDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MiCardDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MiCardDO::getId).last("limit 1"));
    }

}
