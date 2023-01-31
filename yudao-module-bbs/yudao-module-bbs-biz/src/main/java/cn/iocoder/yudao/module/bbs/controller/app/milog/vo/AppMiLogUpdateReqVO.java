package cn.iocoder.yudao.module.bbs.controller.app.milog.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("用户 APP - 米日志更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMiLogUpdateReqVO extends AppMiLogBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "1178")
    @NotNull(message = "id不能为空")
    private Long id;

}
