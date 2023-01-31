package cn.iocoder.yudao.module.bbs.service.micard;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bbs.controller.app.micard.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.micard.MiCardDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.bbs.convert.micard.MiCardConvert;
import cn.iocoder.yudao.module.bbs.dal.mysql.micard.MiCardMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;

/**
 * 米卡密 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MiCardServiceImpl implements MiCardService {

    @Resource
    private MiCardMapper miCardMapper;

    @Override
    public Long createMiCard(AppMiCardCreateReqVO createReqVO) {
        // 插入
        MiCardDO miCard = MiCardConvert.INSTANCE.convert(createReqVO);
        miCardMapper.insert(miCard);
        // 返回
        return miCard.getId();
    }

    @Override
    public void updateMiCard(AppMiCardUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMiCardExists(updateReqVO.getId());
        // 更新
        MiCardDO updateObj = MiCardConvert.INSTANCE.convert(updateReqVO);
        miCardMapper.updateById(updateObj);
    }

    @Override
    public void deleteMiCard(Long id) {
        // 校验存在
        this.validateMiCardExists(id);
        // 删除
        miCardMapper.deleteById(id);
    }

    private void validateMiCardExists(Long id) {
        if (miCardMapper.selectById(id) == null) {
            throw exception(MI_CARD_NOT_EXISTS);
        }
    }

    @Override
    public MiCardDO getMiCard(Long id) {
        return miCardMapper.selectById(id);
    }

    @Override
    public List<MiCardDO> getMiCardList(Collection<Long> ids) {
        return miCardMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MiCardDO> getMiCardPage(AppMiCardPageReqVO pageReqVO) {
        return miCardMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MiCardDO> getMiCardList(AppMiCardExportReqVO exportReqVO) {
        return miCardMapper.selectList(exportReqVO);
    }

}
