package cn.iocoder.yudao.module.bbs.service.mijob;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.app.mijob.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.mijob.MiJobDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.mijob.MiJobMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link MiJobServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MiJobServiceImpl.class)
public class MiJobServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MiJobServiceImpl miJobService;

    @Resource
    private MiJobMapper miJobMapper;

    @Test
    public void testCreateMiJob_success() {
        // 准备参数
        AppMiJobCreateReqVO reqVO = randomPojo(AppMiJobCreateReqVO.class);

        // 调用
        Long miJobId = miJobService.createMiJob(reqVO);
        // 断言
        assertNotNull(miJobId);
        // 校验记录的属性是否正确
        MiJobDO miJob = miJobMapper.selectById(miJobId);
        assertPojoEquals(reqVO, miJob);
    }

    @Test
    public void testUpdateMiJob_success() {
        // mock 数据
        MiJobDO dbMiJob = randomPojo(MiJobDO.class);
        miJobMapper.insert(dbMiJob);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AppMiJobUpdateReqVO reqVO = randomPojo(AppMiJobUpdateReqVO.class, o -> {
            o.setId(dbMiJob.getId()); // 设置更新的 ID
        });

        // 调用
        miJobService.updateMiJob(reqVO);
        // 校验是否更新正确
        MiJobDO miJob = miJobMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, miJob);
    }

    @Test
    public void testUpdateMiJob_notExists() {
        // 准备参数
        AppMiJobUpdateReqVO reqVO = randomPojo(AppMiJobUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> miJobService.updateMiJob(reqVO), MI_JOB_NOT_EXISTS);
    }

    @Test
    public void testDeleteMiJob_success() {
        // mock 数据
        MiJobDO dbMiJob = randomPojo(MiJobDO.class);
        miJobMapper.insert(dbMiJob);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMiJob.getId();

        // 调用
        miJobService.deleteMiJob(id);
       // 校验数据不存在了
       assertNull(miJobMapper.selectById(id));
    }

    @Test
    public void testDeleteMiJob_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> miJobService.deleteMiJob(id), MI_JOB_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMiJobPage() {
       // mock 数据
       MiJobDO dbMiJob = randomPojo(MiJobDO.class, o -> { // 等会查询到
           o.setMobile(null);
           o.setPwd(null);
           o.setCardNo(null);
           o.setCron(null);
           o.setMinStep(null);
           o.setMaxStep(null);
           o.setEndTime(null);
           o.setJobId(null);
           o.setUserId(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       miJobMapper.insert(dbMiJob);
       // 测试 mobile 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setMobile(null)));
       // 测试 pwd 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setPwd(null)));
       // 测试 cardNo 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setCardNo(null)));
       // 测试 cron 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setCron(null)));
       // 测试 minStep 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setMinStep(null)));
       // 测试 maxStep 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setMaxStep(null)));
       // 测试 endTime 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setEndTime(null)));
       // 测试 jobId 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setJobId(null)));
       // 测试 userId 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setUserId(null)));
       // 测试 status 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setCreateTime(null)));
       // 准备参数
       AppMiJobPageReqVO reqVO = new AppMiJobPageReqVO();
       reqVO.setMobile(null);
       reqVO.setPwd(null);
       reqVO.setCardNo(null);
       reqVO.setCron(null);
       reqVO.setMinStep(null);
       reqVO.setMaxStep(null);
       reqVO.setEndTime((new LocalDateTime[]{}));
       reqVO.setJobId(null);
       reqVO.setUserId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<MiJobDO> pageResult = miJobService.getMiJobPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMiJob, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMiJobList() {
       // mock 数据
       MiJobDO dbMiJob = randomPojo(MiJobDO.class, o -> { // 等会查询到
           o.setMobile(null);
           o.setPwd(null);
           o.setCardNo(null);
           o.setCron(null);
           o.setMinStep(null);
           o.setMaxStep(null);
           o.setEndTime(null);
           o.setJobId(null);
           o.setUserId(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       miJobMapper.insert(dbMiJob);
       // 测试 mobile 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setMobile(null)));
       // 测试 pwd 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setPwd(null)));
       // 测试 cardNo 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setCardNo(null)));
       // 测试 cron 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setCron(null)));
       // 测试 minStep 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setMinStep(null)));
       // 测试 maxStep 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setMaxStep(null)));
       // 测试 endTime 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setEndTime(null)));
       // 测试 jobId 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setJobId(null)));
       // 测试 userId 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setUserId(null)));
       // 测试 status 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       miJobMapper.insert(cloneIgnoreId(dbMiJob, o -> o.setCreateTime(null)));
       // 准备参数
       AppMiJobExportReqVO reqVO = new AppMiJobExportReqVO();
       reqVO.setMobile(null);
       reqVO.setPwd(null);
       reqVO.setCardNo(null);
       reqVO.setCron(null);
       reqVO.setMinStep(null);
       reqVO.setMaxStep(null);
       reqVO.setEndTime((new LocalDateTime[]{}));
       reqVO.setJobId(null);
       reqVO.setUserId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<MiJobDO> list = miJobService.getMiJobList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMiJob, list.get(0));
    }

}
