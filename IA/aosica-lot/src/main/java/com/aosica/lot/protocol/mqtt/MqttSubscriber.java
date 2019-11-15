package com.aosica.lot.protocol.mqtt;


import com.aosica.lot.scheduled.MqttProtocolDataHandle;
import com.aosica.lot.service.DeviceDataService;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 *
 * 客户端(物联平台)接收(订阅)消息----->采集器传送的数据
 * 消息订阅:TOPIC
 * @author yuzp
 * topic : stds/up/CL/866262042853449
 *
 */
//@Component
public class MqttSubscriber {

    private final static Logger LOGGER = LoggerFactory.getLogger(MqttSubscriber.class) ;

    //  阿里云配置
    //public static final String HOST = "tcp://120.76.130.172:1883";
//    public static final String HOST = "tcp://139.9.220.27:1883";
//    public static final String TOPIC_NAME = "stds/+/+/866262045467163";
//    private static final String clientid = "client1";


    /**------------------------------------------- 华为云 mqtt 配置  ----------------------------------**/

    // 部署mqtt 服务的主机ip和端口
    public static final String HOST = "tcp://139.9.220.27:1883";
    // 订阅的消息主题
    public static final String TOPIC_NAME = "stds/+/+/866262045467163";

    // 客户端id
    private static final String CLIENTID = UUID.randomUUID().toString().replace("-", "");

    private MqttClient mqttClient;
    private MqttConnectOptions options;  
    private String userName = "test";    //非必须
    private String passWord = "test";  //非必须



    @Autowired
    private DeviceDataService deviceDataService ;

    @Autowired
    private MqttProtocolDataHandle mqttProtocolDataHandle ;


    @PostConstruct
    private void start() {

        LOGGER.info(" subscriber 正在尝试连接 mqtt broker ..................");
        try {  
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存  
            mqttClient = new MqttClient(HOST, CLIENTID, new MemoryPersistence());

            // MQTT的连接设置
            options = new MqttConnectOptions();

            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接  
            options.setCleanSession(false);

            // 设置连接的用户名  
            options.setUserName(userName);  

            // 设置连接的密码
            options.setPassword(passWord.toCharArray());  

            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);

            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);


            //设置消息定阅回调
            mqttClient.setCallback(new SubscribeCallback(deviceDataService,mqttProtocolDataHandle));

//            // 定义客户端传来消息的最大时间间隔秒数，服务器可以据此判断与客户端的连接是否已经断开，从而避免TCP/IP超时的长时间等待
//            mqttClient.setKeepAlive((short) 60);

            //MqttTopic topic = mqttClient.getTopic(TOPIC_NAME);
            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息//遗嘱
            //options.setWill(topic, "close".getBytes(), 2, true);

            mqttClient.connect(options);
            LOGGER.info(" subscriber 连接 mqtt broker 成功..................");
            //订阅消息  ,消息传输方式。
            int[] Qos  = {1};  
            String[] topic1 = {TOPIC_NAME};
            mqttClient.subscribe(topic1, Qos);
            LOGGER.info(" subscriber 向 mqtt broker 订阅消息，topic="+TOPIC_NAME+" ..................");

        }
        catch (Exception e) {
            e.printStackTrace();  
        }  
    }  

    public static void main(String[] args) throws MqttException {
        MqttSubscriber client = new MqttSubscriber();
        client.start();  
    }  
}  
