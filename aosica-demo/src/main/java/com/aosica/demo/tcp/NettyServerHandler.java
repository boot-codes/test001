package com.aosica.demo.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


/**
 * 业务处理器
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 对于处理入站的IO事件的方法，对应的接口为 ChannelInboundHandler 入站处理接口，
     * 而ChannelInboundHandlerAdapter则是Netty提供的入站处理的默认实现。
     * @param ctx
     * @param msg
     */


    /**
     * 供的入站处理的默认实现。
     * 也就是说，如果要实现自己的入站处理器Handler，只要继承ChannelInboundHandlerAdapter入站处理器，再写入自己的入站处理的业务逻辑。如果要读取入站的数据，
     * 只要写在了入站处理方法channelRead中即可。
     * @param ctx
     * @param msg
     */
    //private Map<String, Channel> channelMap = new ConcurrentHashMap<>() ;

    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //Channel channel = ctx.channel();
        System.out.println("接受客户端的数据：" );

        ByteBuf buffer = (ByteBuf)msg;
		byte[] req = new byte[buffer.readableBytes()];
        buffer.readBytes(req);

		String data= new String(req,"UTF-8") ;

        System.out.println(data);

//        2A 50 11 80 430 00000000000000000EE00000000000000999999990300010199999999030001010110000000000000030001014C524E470000000003031820080319200000000037FFDB054D533332138305435823
        StringBuffer stringBuilder = new StringBuffer(data) ;

        System.out.println("head ==>:"+stringBuilder.substring(0, 2));
        System.out.println("data length => " +stringBuilder.substring(2, 4));
        System.out.println("data type => " +stringBuilder.substring(4, 6));
        System.out.println("AckErr => " +stringBuilder.substring(6, 8));
        System.out.println("帧号 => " +stringBuilder.substring(8, 11));
        System.out.println("工程id  => " +stringBuilder.substring(11, 19));
        System.out.println("保留  => " +stringBuilder.substring(11, 19));
        System.out.println("控制器序列号（产品标识+批次+编号）  => " +stringBuilder.substring(11, 19));
//        System.out.println("控制器序列号  => " +stringBuilder.substring(11, 19));

        //网络注册
//        System.out.println("网络注册  => " +stringBuilder.substring(11, 19));
//        保留
//        System.out.println("保留  => " +stringBuilder.substring(11, 19));

//                产品标识
//        System.out.println("产品标识  => " +stringBuilder.substring(11, 19));


//        网络ID
//        System.out.println("网络ID  => " +stringBuilder.substring(11, 19));


//        步长（保留）
//        System.out.println("步长（保留）  => " +stringBuilder.substring(11, 19));

//        通道数量
//        System.out.println("通道数量  => " +stringBuilder.substring(11, 19));

//                硬件版本
//        System.out.println("硬件版本  => " +stringBuilder.substring(11, 19));


//        固件版本
//        System.out.println("固件版本  => " +stringBuilder.substring(11, 19));



//                芯片ID_A
//        System.out.println("芯片ID_A  => " +stringBuilder.substring(11, 19));



//        芯片ID_B
//        System.out.println("芯片ID_B  => " +stringBuilder.substring(11, 19));



//                芯片ID_C
//        System.out.println("芯片ID_C  => " +stringBuilder.substring(11, 19));



//        芯片ID_D
//        System.out.println("芯片ID_D  => " +stringBuilder.substring(11, 19));




        System.out.println("原始数据：" +stringBuilder);



        //ByteBuf headByteBuf = buffer.readBytes(0);
        //System.out.println("head :" +head);

        //String s = ByteBufUtil.hexDump(buffer);
        //System.out.println("s-->" +s);


        //MessageProto.Message message = (MessageProto.Message) msg;

        //ChannelSession.put(message.getId(),channel);
        //System.out.println(message.getId());

        //ChannelSession.pint();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
