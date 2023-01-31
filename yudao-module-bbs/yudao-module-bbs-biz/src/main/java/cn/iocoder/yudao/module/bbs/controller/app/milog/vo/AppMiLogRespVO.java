package cn.iocoder.yudao.module.bbs.controller.app.milog.vo;

import lombok.*;
import java.time.LocalDateTime;
import io.swagger.annotations.*;

@ApiModel("用户 APP - 米日志 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMiLogRespVO extends AppMiLogBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "1178")
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;

}
