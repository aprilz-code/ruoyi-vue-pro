package cn.iocoder.yudao.module.bbs.service.micard;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.app.micard.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.micard.MiCardDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.micard.MiCardMapper;
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
* {@link MiCardServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MiCardServiceImpl.class)
public class MiCardServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MiCardServiceImpl miCardService;

    @Resource
    private MiCardMapper miCardMapper;

    @Test
    public void testCreateMiCard_success() {
        // 准备参数
        AppMiCardCreateReqVO reqVO = randomPojo(AppMiCardCreateReqVO.class);

        // 调用
        Long miCardId = miCardService.createMiCard(reqVO);
        // 断言
        assertNotNull(miCardId);
        // 校验记录的属性是否正确
        MiCardDO miCard = miCardMapper.selectById(miCardId);
        assertPojoEquals(reqVO, miCard);
    }

    @Test
    public void testUpdateMiCard_success() {
        // mock 数据
        MiCardDO dbMiCard = randomPojo(MiCardDO.class);
        miCardMapper.insert(dbMiCard);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AppMiCardUpdateReqVO reqVO = randomPojo(AppMiCardUpdateReqVO.class, o -> {
            o.setId(dbMiCard.getId()); // 设置更新的 ID
        });

        // 调用
        miCardService.updateMiCard(reqVO);
        // 校验是否更新正确
        MiCardDO miCard = miCardMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, miCard);
    }

    @Test
    public void testUpdateMiCard_notExists() {
        // 准备参数
        AppMiCardUpdateReqVO reqVO = randomPojo(AppMiCardUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> miCardService.updateMiCard(reqVO), MI_CARD_NOT_EXISTS);
    }

    @Test
    public void testDeleteMiCard_success() {
        // mock 数据
        MiCardDO dbMiCard = randomPojo(MiCardDO.class);
        miCardMapper.insert(dbMiCard);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMiCard.getId();

        // 调用
        miCardService.deleteMiCard(id);
       // 校验数据不存在了
       assertNull(miCardMapper.selectById(id));
    }

    @Test
    public void testDeleteMiCard_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> miCardService.deleteMiCard(id), MI_CARD_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMiCardPage() {
       // mock 数据
       MiCardDO dbMiCard = randomPojo(MiCardDO.class, o -> { // 等会查询到
           o.setCardNo(null);
           o.setType(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       miCardMapper.insert(dbMiCard);
       // 测试 cardNo 不匹配
       miCardMapper.insert(cloneIgnoreId(dbMiCard, o -> o.setCardNo(null)));
       // 测试 type 不匹配
       miCardMapper.insert(cloneIgnoreId(dbMiCard, o -> o.setType(null)));
       // 测试 status 不匹配
       miCardMapper.insert(cloneIgnoreId(dbMiCard, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       miCardMapper.insert(cloneIgnoreId(dbMiCard, o -> o.setCreateTime(null)));
       // 准备参数
       AppMiCardPageReqVO reqVO = new AppMiCardPageReqVO();
       reqVO.setCardNo(null);
       reqVO.setType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<MiCardDO> pageResult = miCardService.getMiCardPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMiCard, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMiCardList() {
       // mock 数据
       MiCardDO dbMiCard = randomPojo(MiCardDO.class, o -> { // 等会查询到
           o.setCardNo(null);
           o.setType(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       miCardMapper.insert(dbMiCard);
       // 测试 cardNo 不匹配
       miCardMapper.insert(cloneIgnoreId(dbMiCard, o -> o.setCardNo(null)));
       // 测试 type 不匹配
       miCardMapper.insert(cloneIgnoreId(dbMiCard, o -> o.setType(null)));
       // 测试 status 不匹配
       miCardMapper.insert(cloneIgnoreId(dbMiCard, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       miCardMapper.insert(cloneIgnoreId(dbMiCard, o -> o.setCreateTime(null)));
       // 准备参数
       AppMiCardExportReqVO reqVO = new AppMiCardExportReqVO();
       reqVO.setCardNo(null);
       reqVO.setType(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<MiCardDO> list = miCardService.getMiCardList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMiCard, list.get(0));
    }

}
