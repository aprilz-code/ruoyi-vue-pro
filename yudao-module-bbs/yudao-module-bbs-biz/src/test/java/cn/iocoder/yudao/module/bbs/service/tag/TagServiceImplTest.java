package cn.iocoder.yudao.module.bbs.service.tag;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.bbs.controller.admin.tag.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.tag.TagDO;
import cn.iocoder.yudao.module.bbs.dal.mysql.tag.TagMapper;
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
* {@link TagServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(TagServiceImpl.class)
public class TagServiceImplTest extends BaseDbUnitTest {

    @Resource
    private TagServiceImpl tagService;

    @Resource
    private TagMapper tagMapper;

    @Test
    public void testCreateTag_success() {
        // 准备参数
        TagCreateReqVO reqVO = randomPojo(TagCreateReqVO.class);

        // 调用
        Long tagId = tagService.createTag(reqVO);
        // 断言
        assertNotNull(tagId);
        // 校验记录的属性是否正确
        TagDO tag = tagMapper.selectById(tagId);
        assertPojoEquals(reqVO, tag);
    }

    @Test
    public void testUpdateTag_success() {
        // mock 数据
        TagDO dbTag = randomPojo(TagDO.class);
        tagMapper.insert(dbTag);// @Sql: 先插入出一条存在的数据
        // 准备参数
        TagUpdateReqVO reqVO = randomPojo(TagUpdateReqVO.class, o -> {
            o.setId(dbTag.getId()); // 设置更新的 ID
        });

        // 调用
        tagService.updateTag(reqVO);
        // 校验是否更新正确
        TagDO tag = tagMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, tag);
    }

    @Test
    public void testUpdateTag_notExists() {
        // 准备参数
        TagUpdateReqVO reqVO = randomPojo(TagUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> tagService.updateTag(reqVO), TAG_NOT_EXISTS);
    }

    @Test
    public void testDeleteTag_success() {
        // mock 数据
        TagDO dbTag = randomPojo(TagDO.class);
        tagMapper.insert(dbTag);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbTag.getId();

        // 调用
        tagService.deleteTag(id);
       // 校验数据不存在了
       assertNull(tagMapper.selectById(id));
    }

    @Test
    public void testDeleteTag_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> tagService.deleteTag(id), TAG_NOT_EXISTS);
    }

    @Test
    @Disabled
    public void testGetTagPage() {
       // mock 数据
       TagDO dbTag = randomPojo(TagDO.class, o -> { // 等会查询到
           o.setContent(null);
           o.setClickCount(null);
           o.setSort(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       tagMapper.insert(dbTag);
       // 测试 content 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setContent(null)));
       // 测试 clickCount 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setClickCount(null)));
       // 测试 sort 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setSort(null)));
       // 测试 status 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setCreateTime(null)));
       // 准备参数
       TagPageReqVO reqVO = new TagPageReqVO();
       reqVO.setContent(null);
       reqVO.setClickCount(null);
       reqVO.setSort(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       PageResult<TagDO> pageResult = tagService.getTagPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbTag, pageResult.getList().get(0));
    }

    @Test
    public void testGetTagList() {
       // mock 数据
       TagDO dbTag = randomPojo(TagDO.class, o -> { // 等会查询到
           o.setContent("jvmsss");
           o.setClickCount(null);
           o.setSort(1);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       tagMapper.insert(dbTag);
       // 测试 content 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setContent(null)));
       // 测试 clickCount 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setClickCount(null)));
       // 测试 sort 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setSort(null)));
       // 测试 status 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       tagMapper.insert(cloneIgnoreId(dbTag, o -> o.setCreateTime(null)));
       // 准备参数
       TagExportReqVO reqVO = new TagExportReqVO();
       reqVO.setContent(null);
       reqVO.setClickCount(null);
       reqVO.setSort(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime((new LocalDateTime[]{}));

       // 调用
       List<TagDO> list = tagService.getTagList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbTag, list.get(0));
    }

}
