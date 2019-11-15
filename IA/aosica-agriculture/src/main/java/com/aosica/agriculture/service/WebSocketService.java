package com.aosica.agriculture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: ai-planting->WebScoketService
 * @description: webscoket
 * @author: dwj
 * @create: 2019-08-30 20:25
 **/

@ServerEndpoint(value = "/ws/asset")
@Component
public class WebSocketService {


    private static Logger log = LoggerFactory.getLogger(WebSocketService.class);
    private static final AtomicInteger onlineUserCount = new AtomicInteger(0);

    private static CopyOnWriteArraySet<Session> userSessions = new CopyOnWriteArraySet<Session>();

//
//    @Autowired
//    private SimpMessagingTemplate template;


    @PostConstruct
    public void init() {
        System.out.println("websocket 加载");
    }


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("session : " +session.getId());
        //System.out.println(session.get);
        userSessions.add(session);
        int cnt = onlineUserCount.incrementAndGet(); // 在线数加1
        log.info("有连接加入，当前连接数为：{}", onlineUserCount.get());
        sendMessage(session, "连接成功");
    }


    /**
     * 接收到客户端消息
     *
     * @param message
     *            客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息：{}",message);
        //sendMessage(session, "收到消息，消息内容："+message);
    }

    /**
     * 发送消息，实践表明，每次浏览器刷新，session会发生变化。
     * @param session
     * @param message
     */
    public static void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(String.format("%s (From Server，Session ID=%s)",message,session.getId()));
        } catch (IOException e) {
            log.error("发送消息出错：{}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param message
     * @throws IOException
     */
    public static void BroadCastInfo(String message) throws IOException {

        for (Session session : userSessions) {
            if(session.isOpen()){
                System.out.println(session +"-->" +message);
                sendMessage(session, message);
            }
        }
    }

    /**
     * 指定Session发送消息
     * @param sessionId
     * @param message
     * @throws IOException
     */
    /**
     * 指定Session发送消息
     * @param sessionId
     * @param message
     * @throws IOException
     */
    public static void sendMessage(String message,String sessionId) throws IOException {
        Session session = null;
        for (Session s : userSessions) {
            if(s.getId().equals(sessionId)){
                session = s;
                break;
            }
        }
        if(session!=null){
            sendMessage(session, message);
        }
        else{
            log.error("没有找到你指定ID的会话：{}",sessionId);
        }
    }




    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        userSessions.remove(session);
        int cnt = onlineUserCount.decrementAndGet();
        log.info("有连接关闭，当前连接数为：{}", cnt);
    }



    /**
     * 出现错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：{}，session ID： {}",error.getMessage(),session.getId());
        error.printStackTrace();
    }



//    @MessageMapping("/send")
//    @SendTo("/topic/send")
//    public Object receiveAndSend() {
//        Object obj = null;
//        System.out.println("接收到的数据"+ JSONObject.toJSONString(obj));
//        return obj;
//    }


//    //发送消息客户端
//    @SendTo("/topic/callback")
//    public void sendToSpecifiedUser(@Payload Object obj)   {
//        //消息转发
//        this.template.convertAndSend("/topic/callback", obj);
//    }

}
