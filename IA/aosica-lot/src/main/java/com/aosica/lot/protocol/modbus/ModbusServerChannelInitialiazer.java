package com.aosica.lot.protocol.modbus;

import com.aosica.lot.service.WeatherDeviceService;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @PackgeName com.aosica.demo.tcp
 * @ClassName ServerChannelInitialiazer.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/26 19:26
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/26$ 19:26$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class ModbusServerChannelInitialiazer extends ChannelInitializer<SocketChannel> {



    private WeatherDeviceService weatherDeviceService ;


    public static final Map<String,SocketChannel> clientMap = new ConcurrentHashMap<>() ;

    public ModbusServerChannelInitialiazer(WeatherDeviceService weatherDeviceService) {
        this.weatherDeviceService = weatherDeviceService ;
    }


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        InetSocketAddress inetSocketAddress = socketChannel.remoteAddress();
        String hostString = inetSocketAddress.getHostString();

        System.out.println("主机 ： " +hostString +"  , 请求建立连接 initChannel............... ");


        clientMap.put(socketChannel.id().asShortText(),socketChannel) ;

        System.out.println(clientMap);


        // 实体类传输数据，protobuf序列化
       // socketChannel.pipeline().addLast("decoder", new ProtobufDecoder(MessageProto.Message.getDefaultInstance()));
        //socketChannel.pipeline().addLast("decoder", new ProtobufDecoder(MessageProto.Message.getDefaultInstance()));
        //socketChannel.pipeline().addLast("encoder", new ProtobufEncoder());

        //监测心跳
        //socketChannel.pipeline().addLast("ping", new IdleStateHandler(60, 20, 60 * 10, TimeUnit.SECONDS));
        //socketChannel.pipeline().addLast("decoder", new MyDecoder());
        //socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 4, 4, -8, 0));

        //socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
//        socketChannel.pipeline().addLast("decoder", new StringDecoder());
//        socketChannel.pipeline().addLast("encoder", new StringEncoder());

        //LineBasedFrameDecoder
        // 针对网络请求的业务处理逻辑
        socketChannel.pipeline().addLast(new ModbusServerHandler(this.weatherDeviceService));
    }

}
