package cn.iocoder.yudao.module.member.api.user;

import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import cn.iocoder.yudao.module.member.convert.user.UserConvert;
import cn.iocoder.yudao.module.member.dal.dataobject.user.MemberUserDO;
import cn.iocoder.yudao.module.member.service.user.MemberUserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 会员用户的 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MemberUserApiImpl implements MemberUserApi {

    @Resource
    private MemberUserService userService;

    @Override
    public MemberUserRespDTO getUser(Long id) {
        MemberUserDO user = userService.getUser(id);
        return UserConvert.INSTANCE.convert2(user);
    }

    @Override
    public List<MemberUserRespDTO> getUsers(Collection<Long> ids) {
        return UserConvert.INSTANCE.convertList2(userService.getUserList(ids));
    }

    @Override
    public List<MemberUserRespDTO> getUserListByNickname(String nickname) {
        return UserConvert.INSTANCE.convertList2(userService.getUserListByNickname(nickname));
    }

    @Override
    public MemberUserRespDTO getUserByMobile(String mobile) {
        return UserConvert.INSTANCE.convert2(userService.getUserByMobile(mobile));
    }

    @Override
    public List<MemberUserRespDTO> getUserListNotCurrent() {
        Long loginUserId = SecurityFrameworkUtils.getLoginUserId();
        return UserConvert.INSTANCE.convertList2(userService.getUserListNotCurrent(loginUserId));
    }

}
