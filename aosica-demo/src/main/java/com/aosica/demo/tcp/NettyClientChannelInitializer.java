package com.aosica.demo.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

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

    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();

    private static final NettyClientHandler CLIENT_HANDLER = new NettyClientHandler();


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //ChannelPipeline pipeline = socketChannel.pipeline();
//        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//        pipeline.addLast(DECODER);
//        pipeline.addLast(ENCODER);

        //socketChannel.pipeline().addLast("decoder", new ProtobufDecoder(MessageProto.Message.getDefaultInstance()));
        //socketChannel.pipeline().addLast("encoder", new ProtobufEncoder());

        socketChannel.pipeline().addLast(CLIENT_HANDLER) ;

    }


}
