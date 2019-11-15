package com.aosica.message.sms.template;

public class SuccusssTemplate implements ShortMessageTemplate {
    private String devtype;
    
    private String status;
    

    public String getDevtype() {
        return devtype;
	}


	public void setDevtype(String devtype) {
		this.devtype = devtype;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


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
}