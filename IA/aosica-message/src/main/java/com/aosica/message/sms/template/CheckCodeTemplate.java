package com.aosica.message.sms.template;

import com.aosica.common.util.Help;

import java.lang.reflect.Field;


public class CheckCodeTemplate implements ShortMessageTemplate {
    private String code;   

//	public String toValue() {
//        String value = "";
//        try {
//            Field[] fields = this.getClass().getDeclaredFields();// 根据Class对象获得属性
//            for (Field f : fields) {
//                String singleValue = "#" + f.getName() + "#" + "="
//                        + Help.exsitOrNot(f.get(this), "null").toString();
//                if (value.equals("")) {
//                    value = singleValue;
//                } else {
//                    value += "&" + singleValue;
//                }
//            }
//            return value;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return value;
//    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

}
