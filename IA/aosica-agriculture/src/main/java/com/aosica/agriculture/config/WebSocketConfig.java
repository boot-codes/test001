package com.aosica.agriculture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @program: ai-planting->WebSocketConfig
 * @description: webSocket 配置类
 * @author: dwj
 * @create: 2019-08-30 20:19
 **/
@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig  {

//implements  WebSocketMessageBrokerConfigurer
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/endpoint").setAllowedOrigins("*").withSockJS();
//    }

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/aosica-agriculture");
//    }


    @Bean
    public ServerEndpointExporter serverEndpointExporter () {
        return new ServerEndpointExporter();
    }


}
