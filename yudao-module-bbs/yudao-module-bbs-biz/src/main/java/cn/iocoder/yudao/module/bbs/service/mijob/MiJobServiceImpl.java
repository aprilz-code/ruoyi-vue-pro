package cn.iocoder.yudao.module.bbs.service.mijob;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bbs.controller.app.mijob.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.mijob.MiJobDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.bbs.convert.mijob.MiJobConvert;
import cn.iocoder.yudao.module.bbs.dal.mysql.mijob.MiJobMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;

/**
 * 米job Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MiJobServiceImpl implements MiJobService {

    @Resource
    private MiJobMapper miJobMapper;

    @Override
    public Long createMiJob(AppMiJobCreateReqVO createReqVO) {
        // 插入
        MiJobDO miJob = MiJobConvert.INSTANCE.convert(createReqVO);
        miJobMapper.insert(miJob);
        // 返回
        return miJob.getId();
    }

    @Override
    public void updateMiJob(AppMiJobUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMiJobExists(updateReqVO.getId());
        // 更新
        MiJobDO updateObj = MiJobConvert.INSTANCE.convert(updateReqVO);
        miJobMapper.updateById(updateObj);
    }

    @Override
    public void deleteMiJob(Long id) {
        // 校验存在
        this.validateMiJobExists(id);
        // 删除
        miJobMapper.deleteById(id);
    }

    private void validateMiJobExists(Long id) {
        if (miJobMapper.selectById(id) == null) {
            throw exception(MI_JOB_NOT_EXISTS);
        }
    }

    @Override
    public MiJobDO getMiJob(Long id) {
        return miJobMapper.selectById(id);
    }

    @Override
    public List<MiJobDO> getMiJobList(Collection<Long> ids) {
        return miJobMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MiJobDO> getMiJobPage(AppMiJobPageReqVO pageReqVO) {
        return miJobMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MiJobDO> getMiJobList(AppMiJobExportReqVO exportReqVO) {
        return miJobMapper.selectList(exportReqVO);
    }

}
