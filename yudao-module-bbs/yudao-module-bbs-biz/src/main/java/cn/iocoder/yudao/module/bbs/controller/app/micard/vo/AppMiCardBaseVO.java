package cn.iocoder.yudao.module.bbs.controller.app.micard.vo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.annotations.*;
import javax.validation.constraints.*;

/**
* 米卡密 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppMiCardBaseVO {

    @ApiModelProperty(value = "卡密", required = true)
    @NotNull(message = "卡密不能为空")
    private String cardNo;

    @ApiModelProperty(value = "1.7day 2.1年 3.永久", required = true, example = "1")
    @NotNull(message = "1.7day 2.1年 3.永久不能为空")
    private Integer type;

    @ApiModelProperty(value = "状态", required = true, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
