package com.aosica.lot.protocol.modbus;

import com.aosica.lot.service.WeatherDeviceService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ResourceLeakDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;


/**
 *  modbus 协议 服务启动类
 */
//@Configuration
public class ModbusServer {


	@Value("${modbus.server.bind.port}")
	public int modbusServerPort ;


	@Autowired
	private WeatherDeviceService weatherDeviceService ;


	/**
	 * 启动服务 modbus 协议服务
	 */
	//@Bean
	@PostConstruct
	public void modbusServerStart() {

        System.out.println("正在开启 modbus 服务...................");
		ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.ADVANCED);
//
//		// 线程组 -> Acceptor线程  主要负责创建新连接 ,监听端口
		EventLoopGroup parentGroup = new NioEventLoopGroup();
//
		// 线程组 -> Processor / Handler   负责读取数据的线程，主要用于读取数据以及业务逻辑处理
		// 表示处理每一条连接的数据读写的线程组
		EventLoopGroup childGroup = new NioEventLoopGroup();

		try {

			ServerBootstrap modbusServerBootstrap = new ServerBootstrap(); // 相当于Netty的服务器
			modbusServerBootstrap.group(parentGroup, childGroup)
					.channel(NioServerSocketChannel.class)  // 监听端口的ServerSocketChannel
					// 表示系统用于临时存放已完成三次握手的请求的队列的最大长度，如果连接建立频繁，服务器处理创建新连接较慢，可以适当调大这个参数
					.option(ChannelOption.SO_BACKLOG, 1024)
					.childOption(ChannelOption.SO_KEEPALIVE, true)  // 表示是否开启TCP底层心跳机制，true为开启
					// Y 表示是否开启Nagle算法，true表示关闭，false表示开启，通俗地说，如果要求高实时性，有数据发送时就马上发送，就关闭，如果需要减少发送次数减少网络交互，就开启。
					.childOption(ChannelOption.TCP_NODELAY, true)
					.childHandler(new ModbusServerChannelInitialiazer(this.weatherDeviceService)) ;
			// 同步等待启动服务器监控端口
			// 调用它的同步阻塞方法 sync 等待绑定操作完成。
            System.out.println("开启 modbus 协议端口号："+modbusServerPort);
			ChannelFuture channelFuture2 = modbusServerBootstrap.bind(modbusServerPort).sync();
			System.out.println("modbus 服务开启成功...................\n");
			// 同步等待关闭启动服务器的结果
			// channelFuture2.channel().closeFuture().sync();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
	}


	
}
