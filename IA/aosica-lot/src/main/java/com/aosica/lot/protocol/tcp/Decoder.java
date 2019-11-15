package com.aosica.lot.protocol.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class Decoder extends ByteToMessageDecoder {

    //为了简单处理，假设协议为每次固定传输200字节
    private static final int POCKET_SIZE = 200;

    //记录上次未读完的字节
    private ByteBuf tempMessage = Unpooled.buffer();


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int buffSize = byteBuf.readableBytes();

        System.out.println("=========收到" + buffSize + "字节========");
        ByteBuf inMessage;

        //加上上次未读取完成的字节
        if (tempMessage.readableBytes() == 0) {
            inMessage = byteBuf;
        }
        else {
            inMessage = Unpooled.buffer();
            inMessage.writeBytes(tempMessage);
            inMessage.writeBytes(byteBuf);
        }

        int counter = inMessage.readableBytes() / POCKET_SIZE;

        for (int i = 0; i < counter; i++) {
            byte[] bytes = new byte[POCKET_SIZE];
            inMessage.readBytes(bytes);
            //将处理的好的消息放入list中向下传递
            list.add(bytes);
        }

        tempMessage.clear();
        if (inMessage.readableBytes() != 0) {
            inMessage.readBytes(tempMessage, inMessage.readableBytes());
        }

    }
}