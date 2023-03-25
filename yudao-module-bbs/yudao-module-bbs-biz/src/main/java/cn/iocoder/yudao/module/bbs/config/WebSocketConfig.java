package cn.iocoder.yudao.module.bbs.config;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.exception.ServiceException;
import cn.iocoder.yudao.framework.security.core.LoginUser;
import cn.iocoder.yudao.module.system.api.oauth2.OAuth2TokenApi;
import cn.iocoder.yudao.module.system.api.oauth2.dto.OAuth2AccessTokenCheckRespDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ImmutableMessageChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Resource
    private OAuth2TokenApi oauth2TokenApi;

    /**
     * websocket+sockjs+stompjs详解及实例 :  https://segmentfault.com/a/1190000017204277
     * 注册stomp站点
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/chat").setAllowedOriginPatterns("*").withSockJS();
    }

    /**
     * 注册拦截"/topic","/queue"的消息
     *
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue");

        // 全局使用的消息前缀（客户端订阅路径上会体现出来）
//        registry.setApplicationDestinationPrefixes("/app");
        // 点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
        // registry.setUserDestinationPrefix("/user/");

    }

    /**
     * 配置客户端入站通道拦截器
     * 这里读取header里的token，做token验证
     *
     * @param registration
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ImmutableMessageChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                //                log.info("--websocket信息发送前--");
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                // 判断是否是连接Command 如果是,需要获取token对象
                if (StompCommand.CONNECT.equals(accessor.getCommand()) || StompCommand.SEND.equals(accessor.getCommand())) {
                    List<String> authorizationHeaders = accessor.getNativeHeader("Authorization");
                    if (authorizationHeaders != null && !authorizationHeaders.isEmpty()) {
                        String token = authorizationHeaders.get(0);
                        // 在这里可以根据 token 进行身份认证
                        LoginUser loginUser = buildLoginUserByToken(token, UserTypeEnum.MEMBER.getValue());
                        if (Objects.nonNull(loginUser)) {
                            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                    loginUser, null, Collections.emptyList());
                            authenticationToken.setDetails(new WebAuthenticationDetailsSource());
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                        } else {
                            throw new ServiceException();
                        }
                    }
                }
                return message;
            }
        });
    }

    private LoginUser buildLoginUserByToken(String token, Integer userType) {
        try {
            OAuth2AccessTokenCheckRespDTO accessToken = oauth2TokenApi.checkAccessToken(token);
            if (accessToken == null) {
                return null;
            }
            // 用户类型不匹配，无权限
            if (ObjectUtil.notEqual(accessToken.getUserType(), userType)) {
                throw new AccessDeniedException("错误的用户类型");
            }
            // 构建登录用户
            return new LoginUser().setId(accessToken.getUserId()).setUserType(accessToken.getUserType())
                    .setTenantId(accessToken.getTenantId()).setScopes(accessToken.getScopes());
        } catch (ServiceException serviceException) {
            // 校验 Token 不通过时，考虑到一些接口是无需登录的，所以直接返回 null 即可
            return null;
        }
    }
}
