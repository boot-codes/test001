package com.aosica.lot.service;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.UUID;


/**
 *  TODO MQtt 协议实现
 * @PackgeName com.aosica.lot.service
 * @ClassName LotMqtt.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/19 20:04
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/19$ 20:04$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class MqttProtocolLot implements LotProtocol {


    // 此部分请填入自己的数据
    // 用户名
    public final static  String USERNAME = "";

    // 密码
    public final static  String PASSWORD = "";

    // 用户ID
    public final static  String USER_ID = "";

    public  void connect() throws Exception {

        // 用于测试的topic,订阅属于自己的所有终端上行数据
        String topic = "/tbs/push/dev_msg/department/" + USER_ID + "/#";

        // 接入服务器域名
        String targetServer = "tc.turboes.com:1883";

        String broker = "tcp://" + targetServer;

        // 用于设置客户端会话的ID。在setCleanSession(false);被调用时，MQTT服务器利用该ID获得相应的会话。此ID应少于23个字符，默认根据本机地址、端口和时间自动生成
        String clientId = UUID.randomUUID().toString();

        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        MemoryPersistence persistence = new MemoryPersistence();
        // 构建mqtt 客户端
        MqttClient mqttClient = new MqttClient(broker, clientId, persistence);

        //连接属性
        MqttConnectOptions connOpts = new MqttConnectOptions();

        // MQTT 3.1.1
        connOpts.setMqttVersion(4);

        // 设置是否自动重连
        connOpts.setAutomaticReconnect(true);
        connOpts.setUserName(USERNAME);
        connOpts.setPassword(PASSWORD.toCharArray());
        // 设置会话心跳时间
        connOpts.setKeepAliveInterval(80);
        // 设置超时时间
       // connOpts.setConnectionTimeout();
        System.out.println(clientId + "，进行连接, 目的地: " + broker);

        // 进行连接
        mqttClient.connect(connOpts);

        mqttClient.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("连接失败,原因:" + cause);
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(System.currentTimeMillis() + "接收到消息,来至Topic [" + topic + "] , 内容是:["
                        + new String(message.getPayload(), "UTF-8") + "], num ");
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                // 如果是qos 0消息 token.resp是没有回复的
                System.out.println("消息发送成功! " + ((token == null || token.getResponse() == null) ? "null" : token.getResponse().getKey()));
            }
        });
        System.out.println(System.currentTimeMillis() + "连接成功:---");
    }


    /**
     * 设置回调函数
     */
    public void callBack(MqttClient mqttClient) {



        // 这个是订阅topic
        // sampleClient.subscribe(topic);
    }

}
