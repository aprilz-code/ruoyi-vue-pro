package cn.iocoder.yudao.module.bbs.controller.app.mi;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.validation.ValidationUtils;
import cn.iocoder.yudao.module.bbs.controller.app.mi.vo.MiSportVo;
import cn.iocoder.yudao.module.bbs.service.mi.MIService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Objects;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "mi相关接口")
@RestController
@RequestMapping("/bbs/mi")
@Validated
@Slf4j
public class AppMiController {

    @Resource
    private MIService miService;

    @PostMapping({"/updateMi"})
    public CommonResult<String> updateMi(@RequestBody MiSportVo miSport) {
        checkParam(miSport);
        String exec = miService.updateMi(miSport);
        return success(exec);
    }

    private void checkParam(MiSportVo miSport) {
        if (miSport.getModel()) {
            //则校验自动化所需参数
            if (StrUtil.isBlank(miSport.getCardNo())) {
                throw new ValidationException("请填写卡密");
            }

            List<MiSportVo.ZdVo> zdList = miSport.getZdList();

            zdList.parallelStream().forEach(zd -> {
                boolean b = ValidationUtils.checkObjAllFieldsHasNull(zd);
                if (b) {
                    throw new ValidationException("请检查参数");
                }
            });

        } else {
            if (Objects.isNull(miSport.getMaxStep()) || Objects.isNull(miSport.getMinStep())) {
                throw new ValidationException("请填写步数");
            }
        }
    }


    @GetMapping({"/getCode"})
    public CommonResult<String> getCode(@RequestParam("type") Integer type) {
        String code = miService.getCode(type);

        return success(code);
    }

}
