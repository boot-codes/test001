package com.aosica.lot.client;


import com.aosica.lot.util.HexBinUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.mqtt.*;

import java.util.concurrent.atomic.AtomicInteger;

import static io.netty.handler.codec.mqtt.MqttMessageType.CONNACK;
import static io.netty.handler.codec.mqtt.MqttQoS.AT_MOST_ONCE;


/**
 *  用于对网络事件，进行读写
 */
public  class NettyClientHandler extends ChannelInboundHandlerAdapter
{


	private final AtomicInteger nextMessageId = new AtomicInteger(1);


	//private ByteBuf requestBuffer;

//	private int counter ;
//
//	private  byte[] req ;

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



		System.out.println("接受服务端发送的数据：" );
		ByteBuf buffer = (ByteBuf)msg;
		byte[] req = new byte[buffer.readableBytes()];
		buffer.readBytes(req);

		//HexBinUtil.bytesToHexString(req)
		//String hexString = HexBinUtil.bytesToHexString(req);
		//hexString.
		System.out.println("===>" +new String(req));

//		String response = (String)msg ;
		//1. 获取数据
		//ByteBuf responseBuffer = (ByteBuf) msg;
		try {

//			MessageProto.Message message = (MessageProto.Message) msg;
//			System.out.println("接收到服务端的响应: " + message);
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


		//String commond1 = "2A521580A90500000000000000000000000000000000260619200124180292F801FF12000000000000008071296F212ED7080F0100000000000000000000000000000000000000000000000000000000000000004A23" ;

		String commond2 = "01031400030ADF010B02F523DA0000000000000000000065F2" ;



//		MqttMessage pubRecMessage = MqttMessageFactory.newMessage(
//				new MqttFixedHeader(MqttMessageType.PUBREC, false, AT_MOST_ONCE, false, 2),
//				MqttMessageIdVariableHeader.from(getNewMessageId().messageId()),
//				null);


		MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(CONNACK, false, AT_MOST_ONCE, false, 0);
		MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("stds/up/CL/866262042853449", getNewMessageId().messageId());
		//MqttConnAckVariableHeader mqttConnAckVariableHeader = new MqttConnAckVariableHeader(, true);


		ByteBuf bufff = Unpooled.copiedBuffer(HexBinUtil.hexStringToBytes(commond2)) ;

		MqttPublishMessage mqttMessage = new MqttPublishMessage(mqttFixedHeader,variableHeader,bufff) ;


		ctx.writeAndFlush(mqttMessage);


		//莫尼特
		//bufff.writeBytes(HexBinUtil.hexStringToBytes(DeviceCommandSet.MANUAL_COLLECT_CONTROLLER_DATA));//对接需要16进制


//
//		ByteBuf message = Unpooled.buffer(content.getBytes().length) ;
//		//message.writeBytes(req) ;
//
//		byte[] data = new byte[message.readableBytes()] ;
//		message.writeBytes(data) ;
		//MessageProto.Message message = MessageProto.Message.newBuilder().setId("11111").setContent("11111").build();




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


	private MqttMessageIdVariableHeader getNewMessageId(){
		this.nextMessageId.compareAndSet(0xffff, 1);
		return MqttMessageIdVariableHeader.from(this.nextMessageId.getAndIncrement());
	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
		cause.printStackTrace();
		ctx.close();
	}
}

