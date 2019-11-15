package com.aosica.message.sms.entity;

/**
 * 发送消息的返回结果实体类
 */
public class MesgResponse {


    /**
     * 状态码
     */
    private  int responseCode ;

    /**
     * 返回消息
     */
    private  String responseMsg ;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    @Override
    public String toString() {
        return "SmsResponse{" +
            "responseCode=" + responseCode +
            ", responseMsg='" + responseMsg + '\'' +
            '}';
    }

}
