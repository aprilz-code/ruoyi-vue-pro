package cn.iocoder.yudao.module.bbs.controller.app.messagetype.vo;

import lombok.*;
import io.swagger.annotations.*;

/**
* 消息类型 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MessageTypeBaseVO {

    @ApiModelProperty(value = "消息类型编码")
    private String typeCode;

    @ApiModelProperty(value = "消息类型名称", example = "赵六")
    private String typeName;

}
