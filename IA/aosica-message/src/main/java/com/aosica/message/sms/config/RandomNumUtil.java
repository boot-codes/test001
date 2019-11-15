package com.aosica.message.sms.config;

import java.util.Random;

/**
 * @program: ai-planting->RandomNumUtil
 * @description: 随机数
 * @author: dwj
 * @create: 2019-09-17 10:30
 **/
public class RandomNumUtil {

    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = randomCode();
        System.out.println(str);
    }
}
