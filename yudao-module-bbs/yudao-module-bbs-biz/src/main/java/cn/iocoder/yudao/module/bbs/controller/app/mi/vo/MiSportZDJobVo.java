package cn.iocoder.yudao.module.bbs.controller.app.mi.vo;

import cn.iocoder.yudao.framework.validator.annotion.BooleanNotNULL;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Classname Mi
 * @Description 小米运动类
 * @Date 2022/12/3 12:09
 * @Created by white
 */
@Data
public class MiSportZDJobVo {

    @NotBlank(message = "手机号码为空，不允许访问")
    private String uin;

    @NotBlank(message = "密码为空，请检查")
    private String pwd;

    private Integer minStep;

    private Integer maxStep;

    private String source;

}

