package cn.iocoder.yudao.module.bbs.convert.article;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.bbs.controller.admin.article.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.article.ArticleDO;

/**
 * 文章 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ArticleConvert {

    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    ArticleDO convert(ArticleCreateReqVO bean);

    ArticleDO convert(ArticleUpdateReqVO bean);

    ArticleRespVO convert(ArticleDO bean);

    List<ArticleRespVO> convertList(List<ArticleDO> list);

    PageResult<ArticleRespVO> convertPage(PageResult<ArticleDO> page);

    List<ArticleExcelVO> convertList02(List<ArticleDO> list);

}
