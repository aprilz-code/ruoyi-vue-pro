package cn.iocoder.yudao.module.bbs.service.messagetype;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.messagetype.MessageTypeDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.messagetype.MessageTypeMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.module.bbs.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link MessageTypeServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(MessageTypeServiceImpl.class)
public class MessageTypeServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MessageTypeServiceImpl messageTypeService;

    @Resource
    private MessageTypeMapper messageTypeMapper;

    @Test
    public void testCreateMessageType_success() {
        // 准备参数
        MessageTypeCreateReqVO reqVO = randomPojo(MessageTypeCreateReqVO.class);

        // 调用
        Long messageTypeId = messageTypeService.createMessageType(reqVO);
        // 断言
        assertNotNull(messageTypeId);
        // 校验记录的属性是否正确
        MessageTypeDO messageType = messageTypeMapper.selectById(messageTypeId);
        assertPojoEquals(reqVO, messageType);
    }

    @Test
    public void testUpdateMessageType_success() {
        // mock 数据
        MessageTypeDO dbMessageType = randomPojo(MessageTypeDO.class);
        messageTypeMapper.insert(dbMessageType);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MessageTypeUpdateReqVO reqVO = randomPojo(MessageTypeUpdateReqVO.class, o -> {
            o.setId(dbMessageType.getId()); // 设置更新的 ID
        });

        // 调用
        messageTypeService.updateMessageType(reqVO);
        // 校验是否更新正确
        MessageTypeDO messageType = messageTypeMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, messageType);
    }

    @Test
    public void testUpdateMessageType_notExists() {
        // 准备参数
        MessageTypeUpdateReqVO reqVO = randomPojo(MessageTypeUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> messageTypeService.updateMessageType(reqVO), MESSAGE_TYPE_NOT_EXISTS);
    }

    @Test
    public void testDeleteMessageType_success() {
        // mock 数据
        MessageTypeDO dbMessageType = randomPojo(MessageTypeDO.class);
        messageTypeMapper.insert(dbMessageType);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMessageType.getId();

        // 调用
        messageTypeService.deleteMessageType(id);
       // 校验数据不存在了
       assertNull(messageTypeMapper.selectById(id));
    }

    @Test
    public void testDeleteMessageType_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> messageTypeService.deleteMessageType(id), MESSAGE_TYPE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMessageTypePage() {
       // mock 数据
       MessageTypeDO dbMessageType = randomPojo(MessageTypeDO.class, o -> { // 等会查询到
           o.setTypeCode(null);
           o.setTypeName(null);
           o.setCreateTime(null);
       });
       messageTypeMapper.insert(dbMessageType);
       // 测试 typeCode 不匹配
       messageTypeMapper.insert(cloneIgnoreId(dbMessageType, o -> o.setTypeCode(null)));
       // 测试 typeName 不匹配
       messageTypeMapper.insert(cloneIgnoreId(dbMessageType, o -> o.setTypeName(null)));
       // 测试 createTime 不匹配
       messageTypeMapper.insert(cloneIgnoreId(dbMessageType, o -> o.setCreateTime(null)));
       // 准备参数
       MessageTypePageReqVO reqVO = new MessageTypePageReqVO();
       reqVO.setTypeCode(null);
       reqVO.setTypeName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<MessageTypeDO> pageResult = messageTypeService.getMessageTypePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMessageType, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMessageTypeList() {
       // mock 数据
       MessageTypeDO dbMessageType = randomPojo(MessageTypeDO.class, o -> { // 等会查询到
           o.setTypeCode(null);
           o.setTypeName(null);
           o.setCreateTime(null);
       });
       messageTypeMapper.insert(dbMessageType);
       // 测试 typeCode 不匹配
       messageTypeMapper.insert(cloneIgnoreId(dbMessageType, o -> o.setTypeCode(null)));
       // 测试 typeName 不匹配
       messageTypeMapper.insert(cloneIgnoreId(dbMessageType, o -> o.setTypeName(null)));
       // 测试 createTime 不匹配
       messageTypeMapper.insert(cloneIgnoreId(dbMessageType, o -> o.setCreateTime(null)));
       // 准备参数
       MessageTypeExportReqVO reqVO = new MessageTypeExportReqVO();
       reqVO.setTypeCode(null);
       reqVO.setTypeName(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<MessageTypeDO> list = messageTypeService.getMessageTypeList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMessageType, list.get(0));
    }

}
