package cn.iocoder.yudao.module.bbs.controller.admin.classify.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 分类 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ClassifyExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("分类名")
    private String classifyName;

    @ExcelProperty("分类简介")
    private String description;

    @ExcelProperty("点击数")
    private Integer clickCount;

    @ExcelProperty("显示顺序")
    private Integer sort;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
