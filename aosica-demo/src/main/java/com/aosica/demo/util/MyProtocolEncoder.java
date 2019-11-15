package com.aosica.demo.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @PackgeName com.aosica.demo.tcp
 * @ClassName MyProtocolEncoder.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/28 20:10
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/28$ 20:10$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class MyProtocolEncoder extends MessageToByteEncoder<MyProtocol> {


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MyProtocol myProtocol, ByteBuf byteBuf) throws Exception {

        byteBuf.writeInt(myProtocol.getHead_data()) ;
        byteBuf.writeInt(myProtocol.getContentLength()) ;
        byteBuf.writeBytes(myProtocol.getContent()) ;

    }



}
