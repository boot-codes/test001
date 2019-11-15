package com.aosica.demo.util;


import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @PackgeName com.aosica.demo.tcp
 * @ClassName ChannelSession.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/27 19:52
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/27$ 19:52$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class ChannelSession {

    private static final Map<String, Channel> channelMap = new ConcurrentHashMap<String, Channel>();

    public static void  put(String clientId, Channel channel) {
        if(!channelMap.containsKey(clientId)) {
            channelMap.put(clientId, channel) ;
        }
    }

    public static Channel get(String clientId) {
        return  channelMap.get(clientId) ;
    }
    public static void pint() {
        System.out.println("--------------------");
        System.out.println(channelMap);
    }

    public static int size(){
        return channelMap.size() ;
    }

    public static Channel get(int index) {

        int n  = 0 ;
        Set<String> strings = channelMap.keySet();
        for (String key : strings) {
            if(n == index) {
                return  channelMap.get(key) ;
            }
            n++ ;
        }
        return  null ;
    }

}
