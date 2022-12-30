package cn.iocoder.yudao.module.bbs.dal.mysql.tag;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.bbs.controller.admin.tag.vo.TagExportReqVO;
import cn.iocoder.yudao.module.bbs.controller.admin.tag.vo.TagPageReqVO;
import cn.iocoder.yudao.module.bbs.dal.dataobject.classify.ClassifyDO;
import cn.iocoder.yudao.module.bbs.dal.dataobject.tag.TagDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 标签 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TagMapper extends BaseMapperX<TagDO> {

    default PageResult<TagDO> selectPage(TagPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TagDO>()
                .eqIfPresent(TagDO::getContent, reqVO.getContent())
                .eqIfPresent(TagDO::getClickCount, reqVO.getClickCount())
                .eqIfPresent(TagDO::getSort, reqVO.getSort())
                .eqIfPresent(TagDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(TagDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TagDO::getSort)
                .orderByDesc(TagDO::getUpdateTime));
    }

    default List<TagDO> selectList(TagExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TagDO>()
                .eqIfPresent(TagDO::getContent, reqVO.getContent())
                .eqIfPresent(TagDO::getClickCount, reqVO.getClickCount())
                .eqIfPresent(TagDO::getSort, reqVO.getSort())
                .eqIfPresent(TagDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(TagDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TagDO::getSort)
                .orderByDesc(TagDO::getUpdateTime));
    }

    @Update("UPDATE bbs_tag t,(select MAX(sort) + 10 maxSort from bbs_tag ) tt  SET t.sort = tt.maxSort   WHERE t.id =#{id}")
    int topTag(Long id);
}
