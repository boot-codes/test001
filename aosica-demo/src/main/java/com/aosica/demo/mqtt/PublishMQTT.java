package com.aosica.demo.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;  
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;  
import org.eclipse.paho.client.mqttv3.MqttException;  
import org.eclipse.paho.client.mqttv3.MqttMessage;  
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;  
import org.eclipse.paho.client.mqttv3.MqttTopic;  
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;  

/**
 * todo 发送消息的设备端
 * Description: 消息发送端向多个客户端推送主题，即不同客户端可向服务器订阅相同主题
 * @author yuzp
 */  
public class PublishMQTT {

    // MQTT安装的服务器地址:MQTT定义的端口号
    //public final static String HOST = "tcp://localhost:1883";


    public final static String HOST = "tcp://180.101.147.115:8883";


    //订阅的主题
    public static final String TOPIC = "test-mqtt";

    //定义MQTT的ID，可以在MQTT服务配置中指定
    private static final String clientid = "server11";  

    // 同步调用客户端，使用阻塞方法与MQTT服务器通信。
    private static MqttClient mqttClient;
    private static MqttTopic mqttTopic;
    private final static String userName = "test";   //非必须
    private final static String passWord = "test";   //非必须



    static {

        try {
            // 内存存储
            // MemoryPersistence设置clientid的保存形式，默认为以内存保存
            MemoryPersistence persistence = new MemoryPersistence();
            mqttClient = new MqttClient(HOST, clientid, persistence);
            connect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /** 
     * 构造函数 
     * @throws MqttException 
     */  
//    public PublishMQTT() throws MqttException {
//
//    }

    /** 
     *  连接MQTT服务器
     */  
    private static void connect() {
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
        options.setKeepAliveInterval(20);  
        try {
            mqttClient.setCallback(new PushCallback());
            mqttClient.connect(options);

            mqttTopic = mqttClient.getTopic(TOPIC);
            System.out.println("连接成功......");
        }
        catch (Exception e) {
            e.printStackTrace();  
        }  
    }  

    /** 
     * 
     * @param topic 
     * @param message 
     * @throws MqttPersistenceException 
     * @throws MqttException 
     */  
//    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException, MqttException {
//        MqttDeliveryToken token = topic.publish(message);
//        token.waitForCompletion();
//        System.out.println("message is published completely! " + token.isComplete());
//    }

    public static void publish(MqttTopic topic , String message) throws Exception {

        // mqtt 消息对象
        MqttMessage mqttMessage = new MqttMessage() ;

        //设置消息的服务质量： 保证消息能到达一次
        mqttMessage.setQos(1);

        mqttMessage.setRetained(true);
        // 发送内容
        mqttMessage.setPayload("**** 这是推送消息的内容".getBytes()) ;

        MqttDeliveryToken token = topic.publish(mqttMessage);
        token.waitForCompletion();

        System.out.println("message is published completely! " + token.isComplete());
    }

    /** 
     *  启动入口 
     * @param args 
     * @throws MqttException 
     */  
    public static void main(String[] args) throws Exception {
        publish(mqttTopic, "这是推送消息的内容");
        // 断开连接
        mqttClient.close();
    }  
}  
