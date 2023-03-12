package cn.iocoder.yudao.module.infra.api.job.vo.job;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class ApiJobCreateReqVO extends JobBaseVO {

    //@ApiModelProperty(value = "处理器的名字", required = true, example = "sysUserSessionTimeoutJob")
    @NotNull(message = "处理器的名字不能为空")
    private String handlerName;

}
