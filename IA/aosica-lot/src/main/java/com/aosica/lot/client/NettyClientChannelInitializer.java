package com.aosica.lot.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @PackgeName com.aosica.demo.tcp
 * @ClassName ClientChannelInitializer.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/26 12:00
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/26$ 12:00$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class NettyClientChannelInitializer  extends ChannelInitializer<SocketChannel> {

//    private static final StringDecoder DECODER = new StringDecoder();
//    private static final StringEncoder ENCODER = new StringEncoder();
//
//    public static final NettyClientHandler CLIENT_HANDLER = new NettyClientHandler();


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
//        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//        pipeline.addLast(DECODER);
//        pipeline.addLast(ENCODER);

        //socketChannel.pipeline().addLast("decoder", new ProtobufDecoder(MessageProto.Message.getDefaultInstance()));
        //socketChannel.pipeline().addLast("encoder", new ProtobufEncoder());

        //socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
//        socketChannel.pipeline().addLast("decoder", new StringDecoder());
//        socketChannel.pipeline().addLast("encoder", new StringEncoder());
        //pipeline.addLast("MqttDecoder", new MqttDecoder());
//        pipeline.addLast("MqttEncoder", MqttEncoder.INSTANCE);
        pipeline.addLast(new NettyClientHandler()) ;

    }


}
