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
public class MiSportVo {

    @NotBlank(message = "手机号码为空，不允许访问")
    private String uin;

    @NotBlank(message = "密码为空，请检查")
    private String pwd;

    private Integer minStep;

    private Integer maxStep;

    @BooleanNotNULL(message = "模式 true自动 false手动")
    private Boolean model;

    private List<ZdVo> zdList;

    private String cardNo;

    private String source;

    @Data
    public static class ZdVo {
        private String time;

        private Integer zdMinStep;

        private Integer zdMaxStep;
    }

}

