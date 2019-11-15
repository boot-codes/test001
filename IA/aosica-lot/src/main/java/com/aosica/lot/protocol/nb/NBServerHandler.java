package com.aosica.lot.protocol.nb;

import com.aosica.lot.dto.CollectorDeviceDataDTO;
import com.aosica.lot.dto.WeatherDeviceDataDTO;
import com.aosica.lot.entity.WeatherDevice;
import com.aosica.lot.service.WeatherDeviceService;
import com.aosica.lot.util.HexBinUtil;
import com.aosica.lot.util.ObjectBuildFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.lang3.StringUtils;


/**
 * 业务处理器
 */
//@Component
public class NBServerHandler extends ChannelInboundHandlerAdapter {


    WeatherDeviceService weatherDeviceService ;


    public NBServerHandler(WeatherDeviceService weatherDeviceService) {
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

//        SocketChannel socketChannel = NettyServerChannelInitialiazer.clientMap.get(id.asShortText());

        //System.out.println("向控制器发送指令..........................");
        //ByteBuf bufff = Unpooled.copiedBuffer(HexBinUtil.hexStringToBytes(DeviceCommandSet.MANUAL_COLLECT_CONTROLLER_DATA)) ;


        //莫尼特
        //bufff.writeBytes(HexBinUtil.hexStringToBytes(DeviceCommandSet.MANUAL_COLLECT_CONTROLLER_DATA));//对接需要16进制



        //手动采集数据，发送指令。
//        System.out.println("手动采集数据，向控制器发送指令..........................");
//        ByteBuf bufff2 = Unpooled.buffer();
//        //莫尼特
//        bufff2.writeBytes(HexBinUtil.hexStringToBytes(DeviceCommandSet.MANUAL_COLLECT_CONTROLLER_DATA));
//
//        socketChannel.writeAndFlush(bufff2).addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) throws Exception {
//                if (future.isSuccess()) {
//                    System.out.println("手动采集数据回写成功");
//                }
//                else {
//                    System.out.println("手动采集数据回写失败");
//                }
//            }
//        });


        //向气象站控制器，发送指令。
//        System.out.println("获取气象数据，向控制器发送指令..........................");
//        //气象数据
//        ByteBuf bufff = Unpooled.buffer();
//        bufff.writeBytes(HexBinUtil.hexStringToBytes(DeviceCommandSet.COMMAND_1));//对接需要16进制
//        socketChannel.writeAndFlush(bufff).addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) throws Exception {
//                if (future.isSuccess()) {
//                    System.out.println("气象数据回写成功");
//                }
//                else {
//                    System.out.println("气象数据回写失败");
//                }
//            }
//        });


    }



    /**
     * 对于处理入站的IO事件的方法，对应的接口为 ChannelInboundHandler 入站处理接口，
     * 而ChannelInboundHandlerAdapter则是Netty提供的入站处理的默认实现。
     */


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
        else if(hexString.startsWith("2A")) {

            if(hexString.startsWith("2A5011")) {
                // 控制器机身信息
                System.out.println("控制器机身信息："+hexString);
            }
            // TODO 手动获取采集器数据。
            else if(hexString.startsWith("2A521580") && hexString.endsWith("23")){

                System.out.println("手动采集数据："+hexString) ;
                String[] arrays = hexString.split("2A521580");

                for (int n =0 ;n< arrays.length ; n++) {

                    String array = arrays[n] ;
                    if(StringUtils.isNotBlank(array)) {
                        String returnData = "2A521580" +arrays[n] ;
                        CollectorDeviceDataDTO collectorDevice = CollectorDeviceDataDTO.buildObject(returnData);
                        System.out.println(collectorDevice) ;
                    }
                }
            }


//            System.out.println("手动采集数据，向控制器发送指令..........................");
//            ByteBuf bufff2 = Unpooled.buffer();
//            //莫尼特
//            bufff2.writeBytes(HexBinUtil.hexStringToBytes(DeviceCommandSet.MANUAL_COLLECT_CONTROLLER_DATA));
//
//            ctx.writeAndFlush(bufff2).addListener(new ChannelFutureListener() {
//                @Override
//                public void operationComplete(ChannelFuture future) throws Exception {
//                    if (future.isSuccess()) {
//                        System.out.println("手动采集数据回写成功");
//                    }
//                    else {
//                        System.out.println("手动采集数据回写失败");
//                    }
//                }
//            });



        }
        else {
            System.out.println("===>" + hexString);
        }
    }





    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
