package com.aosica.fscp.config;



/**
 * @program: ai-planting->WebSocketConfig
 * @description: webSocket 配置类
 * @author: dwj
 * @create: 2019-08-30 20:19
 **/
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
//
//    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//        //注册STOMP协议节点，同时指定使用SockJS协议。 添加一个服务端点endpoint 客户端通过endpoint来连接
//        stompEndpointRegistry.addEndpoint("/endpoint").withSockJS();
//    }
//
//    //configureMessageBroker方法用来配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        //客户端接收服务端消息地址前缀
//        registry.enableSimpleBroker("/topic");
//        //服务端接收客户端消息地址前缀
//        registry.setApplicationDestinationPrefixes("/app");
//    }
//
//}
