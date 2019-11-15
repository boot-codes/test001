package com.aosica.demo.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

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
public class NettyServerChannelInitialiazer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        System.out.println(".................. server initChannel................");

        // 实体类传输数据，protobuf序列化
       // socketChannel.pipeline().addLast("decoder", new ProtobufDecoder(MessageProto.Message.getDefaultInstance()));
        //socketChannel.pipeline().addLast("decoder", new ProtobufDecoder(MessageProto.Message.getDefaultInstance()));
        //socketChannel.pipeline().addLast("encoder", new ProtobufEncoder());

        //监测心跳
        //socketChannel.pipeline().addLast("ping", new IdleStateHandler(60, 20, 60 * 10, TimeUnit.SECONDS));
        //socketChannel.pipeline().addLast("decoder", new MyDecoder());
        //socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 4, 4, -8, 0));

        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        socketChannel.pipeline().addLast(new StringDecoder());
        // 针对网络请求的业务处理逻辑
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }

}
