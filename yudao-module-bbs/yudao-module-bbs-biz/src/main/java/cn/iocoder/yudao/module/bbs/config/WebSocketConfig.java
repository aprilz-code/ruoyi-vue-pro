package cn.iocoder.yudao.module.bbs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  /**
   * websocket+sockjs+stompjs详解及实例 :  https://segmentfault.com/a/1190000017204277
   * 注册stomp站点
   * @param registry
   */
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {

    registry.addEndpoint("/ws/chat").setAllowedOrigins("*").withSockJS();

  }

  /**
   * 注册拦截"/topic","/queue"的消息
   * @param registry
   */
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic","/queue");

  }
}
