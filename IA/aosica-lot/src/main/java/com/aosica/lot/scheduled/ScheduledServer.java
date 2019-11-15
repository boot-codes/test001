package com.aosica.lot.scheduled;

import com.aosica.lot.util.HexBinUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;

/**
 * @PackgeName com.aosica.lot.scheduled
 * @ClassName ScheduledServer.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/6 17:30
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/6$ 17:30$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class ScheduledServer implements Runnable {

    private ChannelHandlerContext channelHandlerContext ;

    // 需要执行的命令
    private final String command;

    public ScheduledServer(ChannelHandlerContext channelHandlerContext,final String command) {
        this.channelHandlerContext = channelHandlerContext ;
        this.command = command ;
    }

    /**
     *
     */
    @Override
    public void run() {

        //向气象站控制器，发送指令。
        System.out.println("获取气象数据，向控制器发送指令..........................");
        //气象数据
        ByteBuf bufff = Unpooled.buffer();
        bufff.writeBytes(HexBinUtil.hexStringToBytes(command));//对接需要16进制
        channelHandlerContext.writeAndFlush(bufff).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("气象数据回写成功");
                }
                else {
                    System.out.println("气象数据回写失败");
                }
            }
        });
    }
}
