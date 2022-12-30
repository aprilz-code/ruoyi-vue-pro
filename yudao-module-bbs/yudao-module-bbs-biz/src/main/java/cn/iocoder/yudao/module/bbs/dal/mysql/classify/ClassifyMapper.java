package cn.iocoder.yudao.module.bbs.dal.mysql.classify;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.bbs.dal.dataobject.classify.ClassifyDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.bbs.controller.admin.classify.vo.*;
import org.apache.ibatis.annotations.Update;

/**
 * 分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ClassifyMapper extends BaseMapperX<ClassifyDO> {

    default PageResult<ClassifyDO> selectPage(ClassifyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ClassifyDO>()
                .likeIfPresent(ClassifyDO::getClassifyName, reqVO.getClassifyName())
                .betweenIfPresent(ClassifyDO::getClickCount, reqVO.getClickCount())
                .eqIfPresent(ClassifyDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ClassifyDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ClassifyDO::getDeleted, reqVO.getDeleted())
                .orderByDesc(ClassifyDO::getSort)
                .orderByDesc(ClassifyDO::getUpdateTime));
    }

    default List<ClassifyDO> selectList(ClassifyExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ClassifyDO>()
                .likeIfPresent(ClassifyDO::getClassifyName, reqVO.getClassifyName())
                .betweenIfPresent(ClassifyDO::getClickCount, reqVO.getClickCount())
                .eqIfPresent(ClassifyDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ClassifyDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ClassifyDO::getDeleted, reqVO.getDeleted())
                .orderByDesc(ClassifyDO::getSort)
                .orderByDesc(ClassifyDO::getUpdateTime));
    }

    @Update("UPDATE bbs_classify t,(select MAX(sort) + 10 maxSort from bbs_classify ) tt  SET t.sort = tt.maxSort   WHERE t.id =#{id}")
    int topClassify(Long id);
}
