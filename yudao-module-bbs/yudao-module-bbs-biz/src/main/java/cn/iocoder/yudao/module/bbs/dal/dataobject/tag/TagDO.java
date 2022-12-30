package cn.iocoder.yudao.module.bbs.dal.dataobject.tag;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 标签 DO
 *
 * @author 芋道源码
 */
@TableName("bbs_tag")
@KeySequence("bbs_tag_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 标签内容
     */
    private String content;
    /**
     * 标签简介
     */
    private Integer clickCount;
    /**
     * 显示顺序
     */
    private Integer sort;

    @ExcelProperty(value = "状态（0正常 1停用）", converter = DictConvert.class)
    @DictFormat("common_status")
    private Integer status;

}
