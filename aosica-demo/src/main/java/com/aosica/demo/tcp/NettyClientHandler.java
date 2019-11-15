package com.aosica.demo.tcp;

import com.aosica.demo.util.MessageProto;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


/**
 *  用于对网络事件，进行读写
 */
public  class NettyClientHandler extends ChannelInboundHandlerAdapter
{

	//private ByteBuf requestBuffer;

	private int counter ;

	private  byte[] req ;

	public NettyClientHandler() {
//		byte[] requestBytes = "你好，我是客户端，我发送了一条消息".getBytes();
//		requestBuffer = Unpooled.buffer(requestBytes.length);
//		requestBuffer.writeBytes(requestBytes);
		//req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes() ;

//		MessageProto.Message message = (MessageProto.Message) msg;
//		System.out.println("client:" + message.getContent());
	}


	/**
	 * 当服务端返回应答消息时，channelRead方法被调用
	 * @param ctx
	 * @param msg
	 * @throws Exception
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception  { // (2)


//		String response = (String)msg ;
		//1. 获取数据
		//ByteBuf responseBuffer = (ByteBuf) msg;
		try {

			MessageProto.Message message = (MessageProto.Message) msg;
			System.out.println("接收到服务端的响应: " + message);
			//System.out.println("client:" + message.getContent());
			//byte[] responseBytes = new byte[responseBuffer.readableBytes()];
			//responseBuffer.readBytes(responseBytes);

			//String response = new String(body, "UTF-8");
			//System.out.println("body"+body+";"+ ++counter);


			//System.out.println("接收到服务端的响应：Now is " + message+" ; the counter is : "+ ++counter);
		}
		finally {
			//responseBuffer.release() ;
		}
	}


	/**
	 * 当客户端和服务端TCP链路建立成功之后，Netty的NIO线程会调用channelActive方法
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {


		System.out.println("客户端通道已建立.....");
		// ctx.write()关没有把消息写到网络上，他在内部被缓存起来，你需要调用ctx.flush()把他刷新到网络上。
		// ctx.writeAndFlush(msg)是个更简洁的方法。

//		ByteBuf message = null ;
//		for (int n=0 ;n<100 ; n++) {
//			message = Unpooled.buffer(req.length) ;
//			message.writeBytes(req) ;
//			ctx.writeAndFlush(message) ;
//		}

		// protobuf
		//String id = UUID.randomUUID().toString().replaceAll("-", "");

//		for(int i=1;i<10 ; i++) {
//			MessageProto.Message message = MessageProto.Message.newBuilder().setId("1111").setContent(i+"").build();
//			Thread.sleep(3000);
//			ctx.writeAndFlush(message);
//		}

//		for(int i=11;i<20 ; i++) {
//			MessageProto.Message message = MessageProto.Message.newBuilder().setId("1111").setContent(i+"").build();
//			Thread.sleep(3000);
//			ctx.writeAndFlush(message);
//		}

		String content = "2A50118043000000000000000000EE00000000000000999999990300010199999999030001010110000000000000030001014C524E470000000003031820080319200000000037FFDB054D533332138305435823" ;

//
//		ByteBuf message = Unpooled.buffer(content.getBytes().length) ;
//		//message.writeBytes(req) ;
//
//		byte[] data = new byte[message.readableBytes()] ;
//		message.writeBytes(data) ;
		//MessageProto.Message message = MessageProto.Message.newBuilder().setId("11111").setContent("11111").build();
		ctx.writeAndFlush(Unpooled.copiedBuffer(content.getBytes()));



//		ByteBuf buf = (ByteBuf)msg;
//		byte[] req = new byte[buf.readableBytes()];
//		buf.readBytes(req);
//
//		String body = new String(req,"UTF-8").substring(0, req.length - System.getProperty("line.separator").length());
//		counter++;
//		System.out.println("body"+body+";"+ ++counter);

//		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString():"BAD ORDER";
//		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//		ctx.writeAndFlush(resp);

		//ctx.writeAndFlush(Unpooled.copiedBuffer(("Hello Server"+System.getProperty("line.separator")).getBytes()));
		//Thread.sleep(1000);
		//ctx.writeAndFlush(Unpooled.copiedBuffer(("Hello Server"+System.getProperty("line.separator")).getBytes()));
		//Thread.sleep(1000);
		//ctx.writeAndFlush(Unpooled.copiedBuffer(("Hello Server"+System.getProperty("line.separator")).getBytes()));

		//ctx.writeAndFlush(requestBuffer);






	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
		cause.printStackTrace();
		ctx.close();
	}
}

