package cn.iocoder.yudao.module.bbs.service.milog;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.app.milog.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.milog.MiLogDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 米日志 Service 接口
 *
 * @author 芋道源码
 */
public interface MiLogService {

    /**
     * 创建米日志
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMiLog(@Valid AppMiLogCreateReqVO createReqVO);

    /**
     * 更新米日志
     *
     * @param updateReqVO 更新信息
     */
    void updateMiLog(@Valid AppMiLogUpdateReqVO updateReqVO);

    /**
     * 删除米日志
     *
     * @param id 编号
     */
    void deleteMiLog(Long id);

    /**
     * 获得米日志
     *
     * @param id 编号
     * @return 米日志
     */
    MiLogDO getMiLog(Long id);

    /**
     * 获得米日志列表
     *
     * @param ids 编号
     * @return 米日志列表
     */
    List<MiLogDO> getMiLogList(Collection<Long> ids);

    /**
     * 获得米日志分页
     *
     * @param pageReqVO 分页查询
     * @return 米日志分页
     */
    PageResult<MiLogDO> getMiLogPage(AppMiLogPageReqVO pageReqVO);

    /**
     * 获得米日志列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 米日志列表
     */
    List<MiLogDO> getMiLogList(AppMiLogExportReqVO exportReqVO);

}
