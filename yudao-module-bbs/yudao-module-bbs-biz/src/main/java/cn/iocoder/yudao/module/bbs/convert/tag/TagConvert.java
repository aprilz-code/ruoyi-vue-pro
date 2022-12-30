package cn.iocoder.yudao.module.bbs.convert.tag;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.admin.tag.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.tag.TagDO;

/**
 * 标签 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TagConvert {

    TagConvert INSTANCE = Mappers.getMapper(TagConvert.class);

    TagDO convert(TagCreateReqVO bean);

    TagDO convert(TagUpdateReqVO bean);

    TagRespVO convert(TagDO bean);

    List<TagRespVO> convertList(List<TagDO> list);

    PageResult<TagRespVO> convertPage(PageResult<TagDO> page);

    List<TagExcelVO> convertList02(List<TagDO> list);

}
