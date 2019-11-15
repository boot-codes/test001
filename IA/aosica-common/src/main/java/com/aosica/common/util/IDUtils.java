package com.aosica.common.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 各种id生成策略
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 * @author	yuzp
 * @date	2015年7月22日下午2:32:10
 * @version 1.0
 */
public class IDUtils {

	private static  final  ThreadLocalRandom random =  ThreadLocalRandom.current();
	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * id生成
	 */
	public static long genItemId() {
		//当前时间x1000，相当于十进制左移3位
		//末尾的3位填充随机数 192.168.0.33
		long id = System.currentTimeMillis()*1000 + random.nextInt(1000);
		return id;
	}

	/**
	 * 生成四位数的验证码
	 */
	public static int smsCode() {
		int code = random.nextInt(8999)+1000;
		while(code<1000) {
			code = random.nextInt(8999)+1000;
		}
        return code ;
	}

	
	public static void main(String[] args) {

		System.out.println(System.currentTimeMillis());
		System.out.println(genItemId());
		//int s = Integer.MAX_VALUE/1000;
		//long t1=0, t2=0;
		//long st = 0;
		//for(int z=0; z<100; z++){
		//	st = System.currentTimeMillis();
		//	for(int i=0;i< s;i++) {
		//		genItemId();
		//	}
		//	t2 += (System.currentTimeMillis()-st);
		//}
		//System.out.println(t1);
		//System.out.println(t2);
	}
}
