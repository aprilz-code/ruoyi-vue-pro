package cn.iocoder.yudao.module.member.api.user.dto;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import lombok.Data;

/**
 * 用户信息 Response DTO
 *
 * @author 芋道源码
 */
@Data
public class MemberUserRespDTO {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 帐号状态
     * <p>
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

    /**
     * 手机
     */
    private String mobile;


    /**
     * 聊天状态 1.在线 2离线 3已注销
     */
    private Integer chatStatus;

    /**
     * 用户头像
     */
    private String avatar;

}
