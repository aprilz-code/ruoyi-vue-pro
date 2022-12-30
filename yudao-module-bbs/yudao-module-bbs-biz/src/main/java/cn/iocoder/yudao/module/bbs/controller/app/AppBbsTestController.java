package cn.iocoder.yudao.module.bbs.controller.app;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;


@Api(tags = "用户 App - Test")
@RestController
@RequestMapping("/bbs/test")
@Validated
public class AppBbsTestController {

    @GetMapping("/get")
    @ApiOperation("获取 test 信息")
    public CommonResult<String> get() {
        return success("true");
    }

}
