package com.aosica.lot.protocol.modbus;

import com.aosica.lot.constant.DeviceCommandSet;
import com.aosica.lot.dto.WeatherDeviceDataDTO;
import com.aosica.lot.entity.WeatherDevice;
import com.aosica.lot.scheduled.ScheduledServer;
import com.aosica.lot.service.WeatherDeviceService;
import com.aosica.lot.util.HexBinUtil;
import com.aosica.lot.util.ObjectBuildFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 业务处理器
 */
public class ModbusServerHandler extends ChannelInboundHandlerAdapter {


    private WeatherDeviceService weatherDeviceService ;


    public ModbusServerHandler(WeatherDeviceService weatherDeviceService) {
        this.weatherDeviceService = weatherDeviceService ;
    }



    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        System.out.println("........handlerAdded..............");
        ChannelId id = ctx.channel().id();
        System.out.println("id==>"+id.asLongText());
    }



    /**
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ChannelId id = ctx.channel().id();
        System.out.println("channel id = " + id.asShortText());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        // 十秒钟执行一次.tmk
        executorService.scheduleWithFixedDelay(
                new ScheduledServer(ctx, DeviceCommandSet.COMMAND_1),
                0,
                10000,
                TimeUnit.MILLISECONDS);





    }




    /**
     * 供的入站处理的默认实现。
     * 也就是说，如果要实现自己的入站处理器Handler，只要继承ChannelInboundHandlerAdapter入站处理器，再写入自己的入站处理的业务逻辑。如果要读取入站的数据，
     * 只要写在了入站处理方法channelRead中即可。
     * @param ctx
     * @param msg
     */
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("\n接受客户端的数据：");
        ByteBuf buffer = (ByteBuf)msg;
        byte[] req = new byte[buffer.readableBytes()];
        buffer.readBytes(req);
        String hexString = HexBinUtil.bytesToHexString(req);
        System.out.println(hexString);

        // 气象五元素
        if(hexString.startsWith("0103")) {

            WeatherDeviceDataDTO weatherDeviceDataDTO = WeatherDeviceDataDTO.buildObject(hexString) ;
            System.out.println("风速、风向、温度、湿度、气压气象数据："+weatherDeviceDataDTO);
            WeatherDevice weatherDeviceData = ObjectBuildFactory.weatherDeviceDataObject(weatherDeviceDataDTO);
            System.out.println(weatherDeviceData);

            int result = this.weatherDeviceService.insert(weatherDeviceData);
            if(result >0) {
                System.out.println("向数据库添加成功................");
            }
        }

    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


}

