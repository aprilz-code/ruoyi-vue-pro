package cn.iocoder.yudao.module.bbs.controller.app.milog.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 米日志 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class AppMiLogExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("最小步数")
    private Integer minStep;

    @ExcelProperty("最大步数")
    private Integer maxStep;

    @ExcelProperty("实际步数")
    private Integer realStep;

    @ExcelProperty("手机号码")
    private String mobile;

    @ExcelProperty("密码")
    private String pwd;

    @ExcelProperty("来源 h5 xxl")
    private String source;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
