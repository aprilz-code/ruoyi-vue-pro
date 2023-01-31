package cn.iocoder.yudao.module.bbs.dal.mysql.mijob;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bbs.dal.dataobject.mijob.MiJobDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bbs.controller.app.mijob.vo.*;

/**
 * 米job Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface MiJobMapper extends BaseMapperX<MiJobDO> {

    default PageResult<MiJobDO> selectPage(AppMiJobPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MiJobDO>()
                .eqIfPresent(MiJobDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MiJobDO::getPwd, reqVO.getPwd())
                .eqIfPresent(MiJobDO::getCardNo, reqVO.getCardNo())
                .eqIfPresent(MiJobDO::getCron, reqVO.getCron())
                .eqIfPresent(MiJobDO::getMinStep, reqVO.getMinStep())
                .eqIfPresent(MiJobDO::getMaxStep, reqVO.getMaxStep())
                .betweenIfPresent(MiJobDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(MiJobDO::getJobId, reqVO.getJobId())
                .eqIfPresent(MiJobDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MiJobDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MiJobDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MiJobDO::getId));
    }

    default List<MiJobDO> selectList(AppMiJobExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MiJobDO>()
                .eqIfPresent(MiJobDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MiJobDO::getPwd, reqVO.getPwd())
                .eqIfPresent(MiJobDO::getCardNo, reqVO.getCardNo())
                .eqIfPresent(MiJobDO::getCron, reqVO.getCron())
                .eqIfPresent(MiJobDO::getMinStep, reqVO.getMinStep())
                .eqIfPresent(MiJobDO::getMaxStep, reqVO.getMaxStep())
                .betweenIfPresent(MiJobDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(MiJobDO::getJobId, reqVO.getJobId())
                .eqIfPresent(MiJobDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MiJobDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MiJobDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MiJobDO::getId));
    }

}
