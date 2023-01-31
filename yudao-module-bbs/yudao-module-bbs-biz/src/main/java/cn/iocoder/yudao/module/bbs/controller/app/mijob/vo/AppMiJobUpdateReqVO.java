package cn.iocoder.yudao.module.bbs.controller.app.mijob.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

@ApiModel("用户 APP - 米job更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMiJobUpdateReqVO extends AppMiJobBaseVO {

    @ApiModelProperty(value = "id", required = true, example = "21038")
    @NotNull(message = "id不能为空")
    private Long id;

}
