package cn.iocoder.yudao.module.bbs.controller.app.micard.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 米卡密 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class AppMiCardExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("卡密")
    private String cardNo;

    @ExcelProperty("1.7day 2.1年 3.永久")
    private Integer type;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
