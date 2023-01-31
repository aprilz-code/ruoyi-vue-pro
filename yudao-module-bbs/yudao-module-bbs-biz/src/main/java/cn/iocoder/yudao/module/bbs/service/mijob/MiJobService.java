package cn.iocoder.yudao.module.bbs.service.mijob;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.app.mijob.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.mijob.MiJobDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 米job Service 接口
 *
 * @author 芋道源码
 */
public interface MiJobService {

    /**
     * 创建米job
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMiJob(@Valid AppMiJobCreateReqVO createReqVO);

    /**
     * 更新米job
     *
     * @param updateReqVO 更新信息
     */
    void updateMiJob(@Valid AppMiJobUpdateReqVO updateReqVO);

    /**
     * 删除米job
     *
     * @param id 编号
     */
    void deleteMiJob(Long id);

    /**
     * 获得米job
     *
     * @param id 编号
     * @return 米job
     */
    MiJobDO getMiJob(Long id);

    /**
     * 获得米job列表
     *
     * @param ids 编号
     * @return 米job列表
     */
    List<MiJobDO> getMiJobList(Collection<Long> ids);

    /**
     * 获得米job分页
     *
     * @param pageReqVO 分页查询
     * @return 米job分页
     */
    PageResult<MiJobDO> getMiJobPage(AppMiJobPageReqVO pageReqVO);

    /**
     * 获得米job列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 米job列表
     */
    List<MiJobDO> getMiJobList(AppMiJobExportReqVO exportReqVO);

}
