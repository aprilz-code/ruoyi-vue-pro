package cn.iocoder.yudao.module.bbs.controller.app.msgcontent.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 私聊消息内容 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MsgContentBaseVO {

    @ApiModelProperty(value = "私聊id,以用户小的id拼上-用户大的id", required = true, example = "26019")
    @NotNull(message = "私聊id,以用户小的id拼上-用户大的id不能为空")
    private String privateChatId;

    @ApiModelProperty(value = "发送者的编号", example = "29717")
    private Integer fromId;

    @ApiModelProperty(value = "发送者的昵称", example = "王五")
    private String fromName;

    @ApiModelProperty(value = "发送者的头像")
    private String fromProfile;

    @ApiModelProperty(value = "消息内容")
    private String content;

    @ApiModelProperty(value = "消息类型编码", example = "2")
    private String messageType;

}
