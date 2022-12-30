package cn.iocoder.yudao.module.bbs.service.tag;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bbs.controller.admin.tag.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.tag.TagDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.bbs.convert.tag.TagConvert;
import cn.iocoder.yudao.module.bbs.dal.mysql.tag.TagMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;

/**
 * 标签 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public Long createTag(TagCreateReqVO createReqVO) {
        // 插入
        TagDO tag = TagConvert.INSTANCE.convert(createReqVO);
        tagMapper.insert(tag);
        // 返回
        return tag.getId();
    }

    @Override
    public void updateTag(TagUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateTagExists(updateReqVO.getId());
        // 更新
        TagDO updateObj = TagConvert.INSTANCE.convert(updateReqVO);
        tagMapper.updateById(updateObj);
    }

    @Override
    public void deleteTag(Long id) {
        // 校验存在
        this.validateTagExists(id);
        // 删除
        tagMapper.deleteById(id);
    }

    private void validateTagExists(Long id) {
        if (tagMapper.selectById(id) == null) {
            throw exception(TAG_NOT_EXISTS);
        }
    }

    @Override
    public TagDO getTag(Long id) {
        return tagMapper.selectById(id);
    }

    @Override
    public List<TagDO> getTagList(Collection<Long> ids) {
        return tagMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TagDO> getTagPage(TagPageReqVO pageReqVO) {
        return tagMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TagDO> getTagList(TagExportReqVO exportReqVO) {
        return tagMapper.selectList(exportReqVO);
    }

    @Override
    public void topTag(Long id) {
        // 校验存在
        this.validateTagExists(id);
        tagMapper.topTag(id);
    }

}
