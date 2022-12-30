package cn.iocoder.yudao.module.bbs.service.classify;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.admin.classify.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.classify.ClassifyDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.classify.ClassifyMapper;
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
* {@link ClassifyServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(ClassifyServiceImpl.class)
public class ClassifyServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ClassifyServiceImpl classifyService;

    @Resource
    private ClassifyMapper classifyMapper;

    @Test
    public void testCreateClassify_success() {
        // 准备参数
        ClassifyCreateReqVO reqVO = randomPojo(ClassifyCreateReqVO.class);

        // 调用
        Long classifyId = classifyService.createClassify(reqVO);
        // 断言
        assertNotNull(classifyId);
        // 校验记录的属性是否正确
        ClassifyDO classify = classifyMapper.selectById(classifyId);
        assertPojoEquals(reqVO, classify);
    }

    @Test
    public void testUpdateClassify_success() {
        // mock 数据
        ClassifyDO dbClassify = randomPojo(ClassifyDO.class);
        classifyMapper.insert(dbClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ClassifyUpdateReqVO reqVO = randomPojo(ClassifyUpdateReqVO.class, o -> {
            o.setId(dbClassify.getId()); // 设置更新的 ID
        });

        // 调用
        classifyService.updateClassify(reqVO);
        // 校验是否更新正确
        ClassifyDO classify = classifyMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, classify);
    }

    @Test
    public void testUpdateClassify_notExists() {
        // 准备参数
        ClassifyUpdateReqVO reqVO = randomPojo(ClassifyUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> classifyService.updateClassify(reqVO), CLASSIFY_NOT_EXISTS);
    }

    @Test
    public void testDeleteClassify_success() {
        // mock 数据
        ClassifyDO dbClassify = randomPojo(ClassifyDO.class);
        classifyMapper.insert(dbClassify);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbClassify.getId();

        // 调用
        classifyService.deleteClassify(id);
       // 校验数据不存在了
       assertNull(classifyMapper.selectById(id));
    }

    @Test
    public void testDeleteClassify_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> classifyService.deleteClassify(id), CLASSIFY_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetClassifyPage() {
       // mock 数据
       ClassifyDO dbClassify = randomPojo(ClassifyDO.class, o -> { // 等会查询到
           o.setClassifyName(null);
           o.setClickCount(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setDeleted(null);
       });
       classifyMapper.insert(dbClassify);
       // 测试 classifyName 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setClassifyName(null)));
       // 测试 clickCount 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setClickCount(null)));
       // 测试 status 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setCreateTime(null)));
       // 测试 deleted 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setDeleted(null)));
       // 准备参数
       ClassifyPageReqVO reqVO = new ClassifyPageReqVO();
       reqVO.setClassifyName(null);
       reqVO.setClickCount(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setDeleted(null);

       // 调用
       PageResult<ClassifyDO> pageResult = classifyService.getClassifyPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbClassify, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetClassifyList() {
       // mock 数据
       ClassifyDO dbClassify = randomPojo(ClassifyDO.class, o -> { // 等会查询到
           o.setClassifyName(null);
           o.setClickCount(null);
           o.setStatus(null);
           o.setCreateTime(null);
           o.setDeleted(null);
       });
       classifyMapper.insert(dbClassify);
       // 测试 classifyName 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setClassifyName(null)));
       // 测试 clickCount 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setClickCount(null)));
       // 测试 status 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setCreateTime(null)));
       // 测试 deleted 不匹配
       classifyMapper.insert(cloneIgnoreId(dbClassify, o -> o.setDeleted(null)));
       // 准备参数
       ClassifyExportReqVO reqVO = new ClassifyExportReqVO();
       reqVO.setClassifyName(null);
       reqVO.setClickCount(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));
       reqVO.setDeleted(null);

       // 调用
       List<ClassifyDO> list = classifyService.getClassifyList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbClassify, list.get(0));
    }

}
