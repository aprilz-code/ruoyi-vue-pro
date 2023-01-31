package cn.iocoder.yudao.module.bbs.convert.micard;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.app.micard.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.micard.MiCardDO;

/**
 * 米卡密 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MiCardConvert {

    MiCardConvert INSTANCE = Mappers.getMapper(MiCardConvert.class);

    MiCardDO convert(AppMiCardCreateReqVO bean);

    MiCardDO convert(AppMiCardUpdateReqVO bean);

    AppMiCardRespVO convert(MiCardDO bean);

    List<AppMiCardRespVO> convertList(List<MiCardDO> list);

    PageResult<AppMiCardRespVO> convertPage(PageResult<MiCardDO> page);

    List<AppMiCardExcelVO> convertList02(List<MiCardDO> list);

}
