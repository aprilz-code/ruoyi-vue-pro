package cn.iocoder.yudao.module.infra.api.job;

import cn.iocoder.yudao.module.infra.api.job.vo.job.ApiJobCreateReqVO;

import javax.validation.Valid;

/**
 * @author Aprilz
 * @date 2023/3/9-19:25
 * @description 创建任务
 */
public interface JobApi {

    /**
     * 创建定时任务
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createJob(@Valid ApiJobCreateReqVO createReqVO) throws Exception;
}
