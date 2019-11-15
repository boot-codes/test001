package com.aosica.demo.mqtt2;


import com.aosica.demo.util.NettySession;
import io.netty.util.AttributeKey;


public interface Attributes {
    AttributeKey<NettySession> SESSION = AttributeKey.newInstance("session");
}
