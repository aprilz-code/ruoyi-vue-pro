package cn.iocoder.yudao.module.bbs.service.groupmsgcontent;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.groupmsgcontent.GroupMsgContentDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.groupmsgcontent.GroupMsgContentMapper;
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
* {@link GroupMsgContentServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(GroupMsgContentServiceImpl.class)
public class GroupMsgContentServiceImplTest extends BaseDbUnitTest {

    @Resource
    private GroupMsgContentServiceImpl groupMsgContentService;

    @Resource
    private GroupMsgContentMapper groupMsgContentMapper;

    @Test
    public void testCreateGroupMsgContent_success() {
        // 准备参数
        GroupMsgContentCreateReqVO reqVO = randomPojo(GroupMsgContentCreateReqVO.class);

        // 调用
        Long groupMsgContentId = groupMsgContentService.createGroupMsgContent(reqVO);
        // 断言
        assertNotNull(groupMsgContentId);
        // 校验记录的属性是否正确
        GroupMsgContentDO groupMsgContent = groupMsgContentMapper.selectById(groupMsgContentId);
        assertPojoEquals(reqVO, groupMsgContent);
    }

    @Test
    public void testUpdateGroupMsgContent_success() {
        // mock 数据
        GroupMsgContentDO dbGroupMsgContent = randomPojo(GroupMsgContentDO.class);
        groupMsgContentMapper.insert(dbGroupMsgContent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        GroupMsgContentUpdateReqVO reqVO = randomPojo(GroupMsgContentUpdateReqVO.class, o -> {
            o.setId(dbGroupMsgContent.getId()); // 设置更新的 ID
        });

        // 调用
        groupMsgContentService.updateGroupMsgContent(reqVO);
        // 校验是否更新正确
        GroupMsgContentDO groupMsgContent = groupMsgContentMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, groupMsgContent);
    }

    @Test
    public void testUpdateGroupMsgContent_notExists() {
        // 准备参数
        GroupMsgContentUpdateReqVO reqVO = randomPojo(GroupMsgContentUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> groupMsgContentService.updateGroupMsgContent(reqVO), GROUP_MSG_CONTENT_NOT_EXISTS);
    }

    @Test
    public void testDeleteGroupMsgContent_success() {
        // mock 数据
        GroupMsgContentDO dbGroupMsgContent = randomPojo(GroupMsgContentDO.class);
        groupMsgContentMapper.insert(dbGroupMsgContent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbGroupMsgContent.getId();

        // 调用
        groupMsgContentService.deleteGroupMsgContent(id);
       // 校验数据不存在了
       assertNull(groupMsgContentMapper.selectById(id));
    }

    @Test
    public void testDeleteGroupMsgContent_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> groupMsgContentService.deleteGroupMsgContent(id), GROUP_MSG_CONTENT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetGroupMsgContentPage() {
       // mock 数据
       GroupMsgContentDO dbGroupMsgContent = randomPojo(GroupMsgContentDO.class, o -> { // 等会查询到
           o.setGroupId(null);
           o.setFromId(null);
           o.setFromName(null);
           o.setFromProfile(null);
           o.setContent(null);
           o.setMessageType(null);
           o.setCreateTime(null);
       });
       groupMsgContentMapper.insert(dbGroupMsgContent);
       // 测试 groupId 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setGroupId(null)));
       // 测试 fromId 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setFromId(null)));
       // 测试 fromName 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setFromName(null)));
       // 测试 fromProfile 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setFromProfile(null)));
       // 测试 content 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setContent(null)));
       // 测试 messageType 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setMessageType(null)));
       // 测试 createTime 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setCreateTime(null)));
       // 准备参数
       GroupMsgContentPageReqVO reqVO = new GroupMsgContentPageReqVO();
       reqVO.setGroupId(null);
       reqVO.setFromId(null);
       reqVO.setFromName(null);
       reqVO.setFromProfile(null);
       reqVO.setContent(null);
       reqVO.setMessageType(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<GroupMsgContentDO> pageResult = groupMsgContentService.getGroupMsgContentPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbGroupMsgContent, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetGroupMsgContentList() {
       // mock 数据
       GroupMsgContentDO dbGroupMsgContent = randomPojo(GroupMsgContentDO.class, o -> { // 等会查询到
           o.setGroupId(null);
           o.setFromId(null);
           o.setFromName(null);
           o.setFromProfile(null);
           o.setContent(null);
           o.setMessageType(null);
           o.setCreateTime(null);
       });
       groupMsgContentMapper.insert(dbGroupMsgContent);
       // 测试 groupId 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setGroupId(null)));
       // 测试 fromId 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setFromId(null)));
       // 测试 fromName 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setFromName(null)));
       // 测试 fromProfile 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setFromProfile(null)));
       // 测试 content 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setContent(null)));
       // 测试 messageType 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setMessageType(null)));
       // 测试 createTime 不匹配
       groupMsgContentMapper.insert(cloneIgnoreId(dbGroupMsgContent, o -> o.setCreateTime(null)));
       // 准备参数
       GroupMsgContentExportReqVO reqVO = new GroupMsgContentExportReqVO();
       reqVO.setGroupId(null);
       reqVO.setFromId(null);
       reqVO.setFromName(null);
       reqVO.setFromProfile(null);
       reqVO.setContent(null);
       reqVO.setMessageType(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<GroupMsgContentDO> list = groupMsgContentService.getGroupMsgContentList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbGroupMsgContent, list.get(0));
    }

}
