package cn.iocoder.yudao.module.bbs.controller.app.micard.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

@ApiModel("用户 APP - 米卡密 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMiCardRespVO extends AppMiCardBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "26061")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
