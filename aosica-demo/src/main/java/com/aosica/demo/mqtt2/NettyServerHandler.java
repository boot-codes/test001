package com.aosica.demo.mqtt2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	private int counter ;


	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

		//System.out.println("客户用户连接.."+ctx.);
		//super.handlerAdded(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


		//ByteBuf buf = (ByteBuf)msg ;
//		String body = (String)msg ;
//		byte[] req = new byte[buf.readableBytes()] ;
//		buf.readBytes(req) ;
		//String body = new String(req,"UTF-8").substring(0,req.length-System.getProperty("line.separator").length()) ;
//		System.out.println("the time server receive order :"+ body +" ; the counter is :"+ ++counter) ;
//
//		String currentTime = "QUERY TIME ORDER ".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString():"BAD ORDER" ;
//
//		currentTime = currentTime +System.getProperty("line.separator") ;
//
//		ByteBuf resp = 	Unpooled.copiedBuffer(currentTime.getBytes()) ;
//		ctx.writeAndFlush(resp) ;

//		ByteBuf buf = (ByteBuf)msg;
//		byte[] req = new byte[buf.readableBytes()];
//		buf.readBytes(req);
//
//		String body = new String(req,"UTF-8").substring(0, req.length - System.getProperty("line.separator").length());
//		counter++;
//		System.out.println("The time server receive order :"+body+";the counter is :"+ ++counter);
//
//		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString():"BAD ORDER";
//		currentTime = currentTime+System.getProperty("line.separator") ;
//		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//		ctx.writeAndFlush(resp);



//		//ByteBuf requestBuffer = (ByteBuf) msg;
//		String body = (String)msg;
////		byte[] requestBytes = new byte[requestBuffer.readableBytes()];
////		requestBuffer.readBytes(requestBytes);
////
////		String request = new String(requestBytes, "UTF-8");
//		System.out.println("接收到客户端发送的请求：" + request);
////
////		String response = "你好，我是服务端，我收到你的消息了";
////		ByteBuf responseBuffer = Unpooled.copiedBuffer(response.getBytes());
//
//		String  conent ="Hello Client"+System.getProperty("line.separator");
//
//		ctx.writeAndFlush(Unpooled.copiedBuffer(conent.getBytes()));
//		//Thread.sleep(1000);
//		ctx.writeAndFlush(Unpooled.copiedBuffer(conent.getBytes()));
//		//Thread.sleep(1000);
//		ctx.writeAndFlush(Unpooled.copiedBuffer(conent.getBytes()));

		//ctx.writeAndFlush(responseBuffer);
		
		// 这个东西类似对应着我们之前说的那个Processor线程，负责读取请求，返回响应
		// 具体底层的源码还没看，这个东西也可以理解为我们之前说的那个Handler线程
		// Netty底层就有类似Processor的东西，负责从网络连接中读取请求
		// 然后把读取出来的请求交给我们的Handler线程来处理，处理完以后把响应返回回去
		// 但是可能在底层响应是由Processor线程来发送回去的
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
}
