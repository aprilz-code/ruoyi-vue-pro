package cn.iocoder.yudao.module.bbs.controller.app.groupmsgcontent.vo;

import lombok.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 群聊消息内容 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class GroupMsgContentBaseVO {

    @ApiModelProperty(value = "群聊id", required = true, example = "15868")
    @NotNull(message = "群聊id不能为空")
    private Long groupId;

    @ApiModelProperty(value = "发送者的编号", example = "77")
    private Long fromId;

    @ApiModelProperty(value = "发送者的昵称", example = "李四")
    private String fromName;

    @ApiModelProperty(value = "发送者的头像")
    private String fromProfile;

    @ApiModelProperty(value = "消息内容")
    private String content;

    @ApiModelProperty(value = "消息类型编码", example = "2")
    private String messageType;

}
