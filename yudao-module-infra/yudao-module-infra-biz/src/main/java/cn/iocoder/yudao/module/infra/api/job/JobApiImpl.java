package cn.iocoder.yudao.module.infra.api.job;

import cn.hutool.core.bean.BeanUtil;
import cn.iocoder.yudao.module.infra.api.job.vo.job.ApiJobCreateReqVO;

import cn.iocoder.yudao.module.infra.controller.admin.job.vo.job.JobCreateReqVO;
import cn.iocoder.yudao.module.infra.service.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;


/**
 * @author Aprilz
 * @date 2023/3/9-19:38
 * @description 定时任务
 */
@Service
@Validated
public class JobApiImpl  implements JobApi {


    @Resource
    private JobService jobService;


    @Override
    public Long createJob( ApiJobCreateReqVO createReqVO)  throws Exception{
        JobCreateReqVO jobCreateReqVO = new JobCreateReqVO();
        BeanUtil.copyProperties(createReqVO,jobCreateReqVO);
       return jobService.createJob(jobCreateReqVO);
    }
}
