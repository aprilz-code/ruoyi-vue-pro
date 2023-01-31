package cn.iocoder.yudao.module.bbs.convert.milog;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.app.milog.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.milog.MiLogDO;

/**
 * 米日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MiLogConvert {

    MiLogConvert INSTANCE = Mappers.getMapper(MiLogConvert.class);

    MiLogDO convert(AppMiLogCreateReqVO bean);

    MiLogDO convert(AppMiLogUpdateReqVO bean);

    AppMiLogRespVO convert(MiLogDO bean);

    List<AppMiLogRespVO> convertList(List<MiLogDO> list);

    PageResult<AppMiLogRespVO> convertPage(PageResult<MiLogDO> page);

    List<AppMiLogExcelVO> convertList02(List<MiLogDO> list);

}
