package cn.iocoder.yudao.module.bbs.controller.app.mijob.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 米job Excel VO
 *
 * @author 芋道源码
 */
@Data
public class AppMiJobExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("手机号码")
    private String mobile;

    @ExcelProperty("密码")
    private String pwd;

    @ExcelProperty("卡密")
    private String cardNo;

    @ExcelProperty("执行计划")
    private String cron;

    @ExcelProperty("最小步数")
    private Integer minStep;

    @ExcelProperty("最大步数")
    private Integer maxStep;

    @ExcelProperty("结束时间")
    private LocalDateTime endTime;

    @ExcelProperty("xxljobId")
    private Integer jobId;

    @ExcelProperty("用户id")
    private Integer userId;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
