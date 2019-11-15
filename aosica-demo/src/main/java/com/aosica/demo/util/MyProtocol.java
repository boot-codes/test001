package com.aosica.demo.util;

import java.util.Arrays;

/**
 *
 *  自定义协议
 * @PackgeName com.aosica.demo.tcp
 * @ClassName MyEncoder.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/8/28 20:06
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/8/28$ 20:06$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class MyProtocol {


    /**
     * 消息的开头的信息标志
     */
    private int head_data = 0X2A;
    /**
     * 消息的长度
     */
    private int contentLength;
    /**
     * 消息的内容
     */
    private byte[] content;


    public int getHead_data() {
        return head_data;
    }

    public void setHead_data(int head_data) {
        this.head_data = head_data;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyEncoder{" +
                "head_data=" + head_data +
                ", contentLength=" + contentLength +
                ", content=" + Arrays.toString(content) +
                '}';
    }


}
