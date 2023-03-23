package cn.iocoder.yudao.module.bbs.controller.app.chat;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.member.api.user.MemberUserApi;
import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

/**
 * @author Hai
 * @date 2020/6/16 - 21:32
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private MemberUserApi memberUserApi;

    @GetMapping("/users")
    public CommonResult<List<MemberUserRespDTO>> getUsersWithoutCurrentUser() {
        return success(memberUserApi.getUserListNotCurrent());
    }
}
