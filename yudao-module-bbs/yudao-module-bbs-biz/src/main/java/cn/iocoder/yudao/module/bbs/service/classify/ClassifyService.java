package cn.iocoder.yudao.module.bbs.service.classify;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.admin.classify.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.classify.ClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 分类 Service 接口
 *
 * @author 芋道源码
 */
public interface ClassifyService {

    /**
     * 创建分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createClassify(@Valid ClassifyCreateReqVO createReqVO);

    /**
     * 更新分类
     *
     * @param updateReqVO 更新信息
     */
    void updateClassify(@Valid ClassifyUpdateReqVO updateReqVO);

    /**
     * 删除分类
     *
     * @param id 编号
     */
    void deleteClassify(Long id);

    /**
     * 获得分类
     *
     * @param id 编号
     * @return 分类
     */
    ClassifyDO getClassify(Long id);

    /**
     * 获得分类列表
     *
     * @param ids 编号
     * @return 分类列表
     */
    List<ClassifyDO> getClassifyList(Collection<Long> ids);

    /**
     * 获得分类分页
     *
     * @param pageReqVO 分页查询
     * @return 分类分页
     */
    PageResult<ClassifyDO> getClassifyPage(ClassifyPageReqVO pageReqVO);

    /**
     * 获得分类列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 分类列表
     */
    List<ClassifyDO> getClassifyList(ClassifyExportReqVO exportReqVO);

}
