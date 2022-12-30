package cn.iocoder.yudao.module.bbs.convert.classify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.admin.classify.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.classify.ClassifyDO;

/**
 * 分类 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ClassifyConvert {

    ClassifyConvert INSTANCE = Mappers.getMapper(ClassifyConvert.class);

    ClassifyDO convert(ClassifyCreateReqVO bean);

    ClassifyDO convert(ClassifyUpdateReqVO bean);

    ClassifyRespVO convert(ClassifyDO bean);

    List<ClassifyRespVO> convertList(List<ClassifyDO> list);

    PageResult<ClassifyRespVO> convertPage(PageResult<ClassifyDO> page);

    List<ClassifyExcelVO> convertList02(List<ClassifyDO> list);

}
