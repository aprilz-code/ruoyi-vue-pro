package cn.iocoder.yudao.module.bbs.controller.app.micard.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("用户 APP - 米卡密更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMiCardUpdateReqVO extends AppMiCardBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "26061")
    @NotNull(message = "id不能为空")
    private Long id;

}
