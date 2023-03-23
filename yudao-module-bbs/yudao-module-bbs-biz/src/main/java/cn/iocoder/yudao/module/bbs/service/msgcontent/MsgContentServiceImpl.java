package cn.iocoder.yudao.module.bbs.service.msgcontent;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.msgcontent.MsgContentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.bbs.convert.msgcontent.MsgContentConvert;
import cn.iocoder.yudao.module.bbs.dal.mysql.msgcontent.MsgContentMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;

/**
 * 私聊消息内容 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MsgContentServiceImpl implements MsgContentService {

    @Resource
    private MsgContentMapper msgContentMapper;

    @Override
    public Long createMsgContent(MsgContentCreateReqVO createReqVO) {
        // 插入
        MsgContentDO msgContent = MsgContentConvert.INSTANCE.convert(createReqVO);
        msgContentMapper.insert(msgContent);
        // 返回
        return msgContent.getId();
    }

    @Override
    public void updateMsgContent(MsgContentUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateMsgContentExists(updateReqVO.getId());
        // 更新
        MsgContentDO updateObj = MsgContentConvert.INSTANCE.convert(updateReqVO);
        msgContentMapper.updateById(updateObj);
    }

    @Override
    public void deleteMsgContent(Long id) {
        // 校验存在
        this.validateMsgContentExists(id);
        // 删除
        msgContentMapper.deleteById(id);
    }

    private void validateMsgContentExists(Long id) {
        if (msgContentMapper.selectById(id) == null) {
            throw exception(MSG_CONTENT_NOT_EXISTS);
        }
    }

    @Override
    public MsgContentDO getMsgContent(Long id) {
        return msgContentMapper.selectById(id);
    }

    @Override
    public List<MsgContentDO> getMsgContentList(Collection<Long> ids) {
        return msgContentMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MsgContentDO> getMsgContentPage(MsgContentPageReqVO pageReqVO) {
        return msgContentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MsgContentDO> getMsgContentList(MsgContentExportReqVO exportReqVO) {
        return msgContentMapper.selectList(exportReqVO);
    }

}
