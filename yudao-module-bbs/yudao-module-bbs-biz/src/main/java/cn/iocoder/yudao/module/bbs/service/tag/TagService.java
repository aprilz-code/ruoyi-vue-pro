package cn.iocoder.yudao.module.bbs.service.tag;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.admin.tag.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.tag.TagDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 标签 Service 接口
 *
 * @author 芋道源码
 */
public interface TagService {

    /**
     * 创建标签
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTag(@Valid TagCreateReqVO createReqVO);

    /**
     * 更新标签
     *
     * @param updateReqVO 更新信息
     */
    void updateTag(@Valid TagUpdateReqVO updateReqVO);

    /**
     * 删除标签
     *
     * @param id 编号
     */
    void deleteTag(Long id);

    /**
     * 获得标签
     *
     * @param id 编号
     * @return 标签
     */
    TagDO getTag(Long id);

    /**
     * 获得标签列表
     *
     * @param ids 编号
     * @return 标签列表
     */
    List<TagDO> getTagList(Collection<Long> ids);

    /**
     * 获得标签分页
     *
     * @param pageReqVO 分页查询
     * @return 标签分页
     */
    PageResult<TagDO> getTagPage(TagPageReqVO pageReqVO);

    /**
     * 获得标签列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 标签列表
     */
    List<TagDO> getTagList(TagExportReqVO exportReqVO);

    void topTag(Long id);

    List<TagDO> selectList();
}
