package cn.iocoder.yudao.module.bbs.convert.mijob;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.app.mijob.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.mijob.MiJobDO;

/**
 * 米job Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MiJobConvert {

    MiJobConvert INSTANCE = Mappers.getMapper(MiJobConvert.class);

    MiJobDO convert(AppMiJobCreateReqVO bean);

    MiJobDO convert(AppMiJobUpdateReqVO bean);

    AppMiJobRespVO convert(MiJobDO bean);

    List<AppMiJobRespVO> convertList(List<MiJobDO> list);

    PageResult<AppMiJobRespVO> convertPage(PageResult<MiJobDO> page);

    List<AppMiJobExcelVO> convertList02(List<MiJobDO> list);

}
