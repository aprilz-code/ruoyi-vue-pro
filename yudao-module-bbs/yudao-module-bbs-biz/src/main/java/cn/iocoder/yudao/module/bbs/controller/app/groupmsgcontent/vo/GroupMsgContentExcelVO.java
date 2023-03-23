package cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo;

import lombok.*;

import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 群聊消息内容 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class GroupMsgContentExcelVO {

    @ExcelProperty("消息内容编号")
    private Long id;

    @ExcelProperty("群聊id")
    private Long groupId;

    @ExcelProperty("发送者的编号")
    private Integer fromId;

    @ExcelProperty("发送者的昵称")
    private String fromName;

    @ExcelProperty("发送者的头像")
    private String fromProfile;

    @ExcelProperty("消息内容")
    private String content;

    @ExcelProperty("消息类型编码")
    private String messageType;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
