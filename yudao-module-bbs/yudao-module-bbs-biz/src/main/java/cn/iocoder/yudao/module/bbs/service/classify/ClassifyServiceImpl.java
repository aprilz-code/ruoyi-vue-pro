package cn.iocoder.yudao.module.bbs.service.classify;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bbs.controller.admin.classify.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.classify.ClassifyDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.bbs.convert.classify.ClassifyConvert;
import cn.iocoder.yudao.module.bbs.dal.mysql.classify.ClassifyMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;

/**
 * 分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ClassifyServiceImpl implements ClassifyService {

    @Resource
    private ClassifyMapper classifyMapper;

    @Override
    public Long createClassify(ClassifyCreateReqVO createReqVO) {
        // 插入
        ClassifyDO classify = ClassifyConvert.INSTANCE.convert(createReqVO);
        classifyMapper.insert(classify);
        // 返回
        return classify.getId();
    }

    @Override
    public void updateClassify(ClassifyUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateClassifyExists(updateReqVO.getId());
        // 更新
        ClassifyDO updateObj = ClassifyConvert.INSTANCE.convert(updateReqVO);
        classifyMapper.updateById(updateObj);
    }

    @Override
    public void deleteClassify(Long id) {
        // 校验存在
        this.validateClassifyExists(id);
        // 删除
        classifyMapper.deleteById(id);
    }

    private void validateClassifyExists(Long id) {
        if (classifyMapper.selectById(id) == null) {
            throw exception(CLASSIFY_NOT_EXISTS);
        }
    }

    @Override
    public ClassifyDO getClassify(Long id) {
        return classifyMapper.selectById(id);
    }

    @Override
    public List<ClassifyDO> getClassifyList(Collection<Long> ids) {
        return classifyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ClassifyDO> getClassifyPage(ClassifyPageReqVO pageReqVO) {
        return classifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ClassifyDO> getClassifyList(ClassifyExportReqVO exportReqVO) {
        return classifyMapper.selectList(exportReqVO);
    }

}
