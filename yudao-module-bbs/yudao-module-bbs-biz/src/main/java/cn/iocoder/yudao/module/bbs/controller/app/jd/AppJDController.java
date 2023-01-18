package cn.iocoder.yudao.module.bbs.controller.app.jd;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.security.core.annotations.PreAuthenticated;
import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJComExchangeReqVO;
import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJComExchangeRespVO;
import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJCommandReqVO;
import cn.iocoder.yudao.module.bbs.service.jd.JdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "jd相关接口")
@RestController
@RequestMapping("/bbs/jd")
@Validated
@Slf4j
public class AppJDController {

    //https://api.nolanstore.top
    @Resource
    private JdService jdService;

    @PostMapping("/jComExchange")
    @ApiOperation(value = "口令解析")
    @PreAuthenticated
    public CommonResult<AppJDJComExchangeRespVO> jComExchange(@RequestBody @Valid AppJDJComExchangeReqVO reqVO) {
        return success(jdService.jComExchange(reqVO));
    }

    @PostMapping("/jCommand")
    @ApiOperation(value = "生成口令")
    @PreAuthenticated
    public CommonResult<String> jCommand(@RequestBody @Valid AppJDJCommandReqVO reqVO) {
        return success(jdService.jCommand(reqVO));
    }
}
