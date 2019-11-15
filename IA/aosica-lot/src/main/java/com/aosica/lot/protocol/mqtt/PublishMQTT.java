package com.aosica.lot.protocol.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * 推送消息，向 mqtt broker
 * Description: 消息发送端向多个客户端推送主题，即不同客户端可向服务器订阅相同主题
 * @author yuzp
 */
//@Component
public class PublishMQTT {


    private final static Logger LOGGER = LoggerFactory.getLogger(PublishMQTT.class) ;

    /**------------------------------------------- 华为云 mqtt 配置  ----------------------------------**/

    // 部署mqtt 服务的主机ip和端口
    public static final String HOST = "tcp://139.9.220.27:1883";

    // 订阅的消息主题
    public static final String TOPIC_NAME = "stds/+/+/866262045467163";


    //定义MQTT的ID，可以在MQTT服务配置中指定，MQTT安装的服务器地址:MQTT定义的端口号
    private static final String CLIENTID = UUID.randomUUID().toString().replace("-", "");;

    // 同步调用客户端，使用阻塞方法与MQTT服务器通信。
    private MqttClient mqttClient;

    private MqttTopic  mqttTopic;

    private final static String userName = "test";   //非必须

    private final static String passWord = "test";   //非必须



    @PostConstruct
    public void init(){
        try {
            // MemoryPersistence设置clientid的保存形式，默认为以内存保存
            mqttClient = new MqttClient(HOST, CLIENTID, new MemoryPersistence());
            connect();
        }
        catch (Exception e) {
            LOGGER.info(" publisher 连接 broker 失败..............");
            e.printStackTrace();
        }
    }


    /** 
     *  连接 MQTT broker 服务器
     */  
    private  void connect() throws Exception{
        // 连接属性
        MqttConnectOptions options = new MqttConnectOptions();

        // 在重新启动和重新连接时记住状态
        options.setCleanSession(false);
        // 设置用户名
        options.setUserName(userName);
        // 设置密码
        options.setPassword(passWord.toCharArray());  
        // 设置超时时间  
        options.setConnectionTimeout(10);  
        // 设置会话心跳时间  
        options.setKeepAliveInterval(30);
        //mqttClient.setCallback(new PushCallback());
        mqttClient.connect(options);

        mqttTopic = mqttClient.getTopic(TOPIC_NAME);
        LOGGER.info(" publisher 连接 broker 成功..............");
    }


    /** 
     *  向 mqtt broker 推送消息，到指定的主题 topic name 上。
     * @param topic 
     * @param message
     * @throws MqttPersistenceException
     * @throws MqttException
     */  


    public void publish(MqttTopic topic , String message) throws Exception {

        // mqtt 消息对象
        MqttMessage mqttMessage = new MqttMessage() ;

        //设置消息的服务质量： 保证消息能到达一次
        mqttMessage.setQos(1);

        mqttMessage.setRetained(true);

        // 发送内容
        mqttMessage.setPayload(message.getBytes()) ;

        MqttDeliveryToken token = topic.publish(mqttMessage);
        token.waitForCompletion();

        LOGGER.info("............ message is published completely ! " + token.isComplete());
    }



    /** 
     *  启动入口 
     * @param args 
     * @throws MqttException
     */  
//    public static void main(String[] args) throws Exception {
//        //publish(mqttTopic, "这是推送消息的内容");
//        // 断开连接
//        //mqttClient.close();
//    }
}  
