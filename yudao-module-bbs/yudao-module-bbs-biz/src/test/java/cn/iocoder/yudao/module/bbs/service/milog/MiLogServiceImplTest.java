package cn.iocoder.yudao.module.bbs.service.milog;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.app.milog.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.milog.MiLogDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.milog.MiLogMapper;
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
* {@link MiLogServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MiLogServiceImpl.class)
public class MiLogServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MiLogServiceImpl miLogService;

    @Resource
    private MiLogMapper miLogMapper;

    @Test
    public void testCreateMiLog_success() {
        // 准备参数
        AppMiLogCreateReqVO reqVO = randomPojo(AppMiLogCreateReqVO.class);

        // 调用
        Long miLogId = miLogService.createMiLog(reqVO);
        // 断言
        assertNotNull(miLogId);
        // 校验记录的属性是否正确
        MiLogDO miLog = miLogMapper.selectById(miLogId);
        assertPojoEquals(reqVO, miLog);
    }

    @Test
    public void testUpdateMiLog_success() {
        // mock 数据
        MiLogDO dbMiLog = randomPojo(MiLogDO.class);
        miLogMapper.insert(dbMiLog);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AppMiLogUpdateReqVO reqVO = randomPojo(AppMiLogUpdateReqVO.class, o -> {
            o.setId(dbMiLog.getId()); // 设置更新的 ID
        });

        // 调用
        miLogService.updateMiLog(reqVO);
        // 校验是否更新正确
        MiLogDO miLog = miLogMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, miLog);
    }

    @Test
    public void testUpdateMiLog_notExists() {
        // 准备参数
        AppMiLogUpdateReqVO reqVO = randomPojo(AppMiLogUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> miLogService.updateMiLog(reqVO), MI_LOG_NOT_EXISTS);
    }

    @Test
    public void testDeleteMiLog_success() {
        // mock 数据
        MiLogDO dbMiLog = randomPojo(MiLogDO.class);
        miLogMapper.insert(dbMiLog);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMiLog.getId();

        // 调用
        miLogService.deleteMiLog(id);
       // 校验数据不存在了
       assertNull(miLogMapper.selectById(id));
    }

    @Test
    public void testDeleteMiLog_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> miLogService.deleteMiLog(id), MI_LOG_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMiLogPage() {
       // mock 数据
       MiLogDO dbMiLog = randomPojo(MiLogDO.class, o -> { // 等会查询到
           o.setMinStep(null);
           o.setMaxStep(null);
           o.setRealStep(null);
           o.setMobile(null);
           o.setPwd(null);
           o.setSource(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       miLogMapper.insert(dbMiLog);
       // 测试 minStep 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setMinStep(null)));
       // 测试 maxStep 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setMaxStep(null)));
       // 测试 realStep 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setRealStep(null)));
       // 测试 mobile 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setMobile(null)));
       // 测试 pwd 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setPwd(null)));
       // 测试 source 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setSource(null)));
       // 测试 status 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setCreateTime(null)));
       // 准备参数
       AppMiLogPageReqVO reqVO = new AppMiLogPageReqVO();
       reqVO.setMinStep(null);
       reqVO.setMaxStep(null);
       reqVO.setRealStep(null);
       reqVO.setMobile(null);
       reqVO.setPwd(null);
       reqVO.setSource(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<MiLogDO> pageResult = miLogService.getMiLogPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMiLog, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMiLogList() {
       // mock 数据
       MiLogDO dbMiLog = randomPojo(MiLogDO.class, o -> { // 等会查询到
           o.setMinStep(null);
           o.setMaxStep(null);
           o.setRealStep(null);
           o.setMobile(null);
           o.setPwd(null);
           o.setSource(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       miLogMapper.insert(dbMiLog);
       // 测试 minStep 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setMinStep(null)));
       // 测试 maxStep 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setMaxStep(null)));
       // 测试 realStep 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setRealStep(null)));
       // 测试 mobile 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setMobile(null)));
       // 测试 pwd 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setPwd(null)));
       // 测试 source 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setSource(null)));
       // 测试 status 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       miLogMapper.insert(cloneIgnoreId(dbMiLog, o -> o.setCreateTime(null)));
       // 准备参数
       AppMiLogExportReqVO reqVO = new AppMiLogExportReqVO();
       reqVO.setMinStep(null);
       reqVO.setMaxStep(null);
       reqVO.setRealStep(null);
       reqVO.setMobile(null);
       reqVO.setPwd(null);
       reqVO.setSource(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<MiLogDO> list = miLogService.getMiLogList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMiLog, list.get(0));
    }

}
