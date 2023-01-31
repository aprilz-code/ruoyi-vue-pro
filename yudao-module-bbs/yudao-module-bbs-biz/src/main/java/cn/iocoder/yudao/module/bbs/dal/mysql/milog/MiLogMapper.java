package cn.iocoder.yudao.module.bbs.dal.mysql.milog;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bbs.dal.dataobject.milog.MiLogDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bbs.controller.app.milog.vo.*;

/**
 * 米日志 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MiLogMapper extends BaseMapperX<MiLogDO> {

    default PageResult<MiLogDO> selectPage(AppMiLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MiLogDO>()
                .eqIfPresent(MiLogDO::getMinStep, reqVO.getMinStep())
                .eqIfPresent(MiLogDO::getMaxStep, reqVO.getMaxStep())
                .eqIfPresent(MiLogDO::getRealStep, reqVO.getRealStep())
                .eqIfPresent(MiLogDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MiLogDO::getPwd, reqVO.getPwd())
                .eqIfPresent(MiLogDO::getSource, reqVO.getSource())
                .eqIfPresent(MiLogDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MiLogDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MiLogDO::getId));
    }

    default List<MiLogDO> selectList(AppMiLogExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MiLogDO>()
                .eqIfPresent(MiLogDO::getMinStep, reqVO.getMinStep())
                .eqIfPresent(MiLogDO::getMaxStep, reqVO.getMaxStep())
                .eqIfPresent(MiLogDO::getRealStep, reqVO.getRealStep())
                .eqIfPresent(MiLogDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MiLogDO::getPwd, reqVO.getPwd())
                .eqIfPresent(MiLogDO::getSource, reqVO.getSource())
                .eqIfPresent(MiLogDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MiLogDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MiLogDO::getId));
    }

}
