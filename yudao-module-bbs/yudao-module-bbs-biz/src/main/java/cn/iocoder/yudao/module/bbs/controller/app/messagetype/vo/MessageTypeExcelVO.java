package cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo;

import lombok.*;

import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 消息类型 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MessageTypeExcelVO {

    @ExcelProperty("消息内容编号")
    private Long id;

    @ExcelProperty("消息类型编码")
    private String typeCode;

    @ExcelProperty("消息类型名称")
    private String typeName;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
