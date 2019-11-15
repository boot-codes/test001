package com.aosica.demo.tcp;

import com.aosica.demo.mqtt.HttpClientUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;



public class NettyClient {

	public final static int MAX_RETRY = 5 ;

	public final  static StringDecoder stringDecoder  = new StringDecoder() ;

	public final  static LineBasedFrameDecoder LINE_BASED_FRAME_DECODER = new LineBasedFrameDecoder(1024) ;




	public static void main(String[] args) {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			// 1.指定线程模型
			bootstrap.group(group)
					// 2.指定 IO 类型为 NIO
					.channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					// 3.IO 处理逻辑
			       .handler(new NettyClientChannelInitializer());

			// 发

//			26u373o988.wicp.vip

			ChannelFuture channelFuture = bootstrap.connect("192.168.110.12", 50070).sync();
//			ChannelFuture channelFuture = bootstrap.connect("192.168.110.12", 50070).sync();
            //ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 50070).sync();

			// 等待客户链路关闭
			channelFuture.channel().closeFuture().sync();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
	}


	
}
