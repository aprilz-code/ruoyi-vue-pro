package cn.iocoder.yudao.module.bbs.service.milog;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bbs.controller.app.milog.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.milog.MiLogDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.bbs.convert.milog.MiLogConvert;
import cn.iocoder.yudao.module.bbs.dal.mysql.milog.MiLogMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;

/**
 * 米日志 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MiLogServiceImpl implements MiLogService {

    @Resource
    private MiLogMapper miLogMapper;

    @Override
    public Long createMiLog(AppMiLogCreateReqVO createReqVO) {
        // 插入
        MiLogDO miLog = MiLogConvert.INSTANCE.convert(createReqVO);
        miLogMapper.insert(miLog);
        // 返回
        return miLog.getId();
    }

    @Override
    public void updateMiLog(AppMiLogUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMiLogExists(updateReqVO.getId());
        // 更新
        MiLogDO updateObj = MiLogConvert.INSTANCE.convert(updateReqVO);
        miLogMapper.updateById(updateObj);
    }

    @Override
    public void deleteMiLog(Long id) {
        // 校验存在
        this.validateMiLogExists(id);
        // 删除
        miLogMapper.deleteById(id);
    }

    private void validateMiLogExists(Long id) {
        if (miLogMapper.selectById(id) == null) {
            throw exception(MI_LOG_NOT_EXISTS);
        }
    }

    @Override
    public MiLogDO getMiLog(Long id) {
        return miLogMapper.selectById(id);
    }

    @Override
    public List<MiLogDO> getMiLogList(Collection<Long> ids) {
        return miLogMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MiLogDO> getMiLogPage(AppMiLogPageReqVO pageReqVO) {
        return miLogMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MiLogDO> getMiLogList(AppMiLogExportReqVO exportReqVO) {
        return miLogMapper.selectList(exportReqVO);
    }

}
