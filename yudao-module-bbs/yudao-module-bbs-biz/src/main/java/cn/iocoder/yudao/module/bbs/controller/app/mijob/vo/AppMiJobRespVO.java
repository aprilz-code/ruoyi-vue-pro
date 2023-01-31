package cn.iocoder.yudao.module.bbs.controller.app.mijob.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

@ApiModel("用户 APP - 米job Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMiJobRespVO extends AppMiJobBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "21038")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
