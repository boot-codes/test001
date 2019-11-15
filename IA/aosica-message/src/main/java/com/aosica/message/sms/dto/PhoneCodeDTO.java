package com.aosica.message.sms.dto;

public class PhoneCodeDTO {

    private  String phoneNum ;

    private String code ;

    private Long createTime ;

    public String getPhoneNum() {
        return phoneNum;
    }

    public PhoneCodeDTO setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this ;
    }

    public String getCode() {
        return code;
    }

    public PhoneCodeDTO setCode(String code) {
        this.code = code;
        return this ;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public PhoneCodeDTO setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this ;
    }

    @Override
    public String toString() {
        return "PhoneCodeDTO{" +
            "phoneNum='" + phoneNum + '\'' +
            ", code=" + code +
            ", createTime=" + createTime +
            '}';
    }
}
