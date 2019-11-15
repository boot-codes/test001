package com.aosica.message.sms.dto;

import com.aosica.common.util.JsonUtil;

import java.lang.reflect.Field;
import java.util.Map;


public class DevStatusMessageDTO {

    /**
     * 设备名称
     */
    private String devtype;

    /**
     * 设备状态
     */
    private String status;

    /**
     * 报警信号
     */
    private long alarmId;

    /**
     * 声音
     */
    private String sournd;

    private int code ;

    private int tel ;

    //检查记录id
    private Map<String,MessageDTO> messageDTO;


    public DevStatusMessageDTO() {
    }

    public DevStatusMessageDTO(Map<String,MessageDTO> messageDTO) {
        this.messageDTO = messageDTO ;
    }

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

    public long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(long alarmId) {
        this.alarmId = alarmId;
    }

    public String getSournd() {
        return sournd;
    }

    public void setSournd(String sournd) {
        this.sournd = sournd;
    }


    public DevStatusMessageDTO(long alarmId, String devtype) {
        this.alarmId = alarmId ;
        this.devtype = devtype ;
    }

    public DevStatusMessageDTO(String devtype, String status) {
        this.devtype = devtype;
        this.status = status;
    }

    public DevStatusMessageDTO(String devtype, String status, long alarmId) {
        this.devtype = devtype;
        this.status = status;
        this.alarmId = alarmId;
    }

    public DevStatusMessageDTO(String devtype, String status, long alarmId, String sournd) {
        this.devtype = devtype;
        this.status = status;
        this.alarmId = alarmId;
        this.sournd = sournd;
    }

    public String getMessage() {
        return  "您有1条"+ devtype +"设备"+ status +"信息，请立即处理，谢谢。";
    }

    public String getOverdueMessage() {
        return "您的辖区内有1条" + devtype + "设备" + devtype + "信息逾期未处理，请您及时联系相关责任人确认，谢谢。";
    }

    public String getVerificationCode() {
        return "尊敬的客户：短信确认码为：\""+code+"\",用于您手机号码(尾号"+tel+")的验证";
    }

    public String getReViewMesg() {
        return JsonUtil.objectToJson(messageDTO) ;
    }

    public static void main(String[] args) {
        DevStatusMessageDTO devStatusMessageDTO = new DevStatusMessageDTO("abc", "dfdfdf", 1, "sddfdf");
        //System.out.println(devStatusMessageDTO.getMessage());
        //System.out.println(devStatusMessageDTO.getOverdueMessage());
        //System.out.println(devStatusMessageDTO.getVerificationCode());
    }

    /**
     * 短信用途
     * @return
     */
    public String toValue()
    {
        String value = "";
        try
        {
            Field[] fields = this.getClass().getDeclaredFields();// 根据Class对象获得属性
            for (Field f : fields) {
                String fieldName = f.getName() ;
                if(!(fieldName.equals("devtype") || fieldName.equals("status"))) {
                    continue;
                }

               String singleValue = "#" + fieldName + "#" + "=" + ((f.get(this) == null) ? null : f.get(this).toString());
                if (value.equals("")) {
                    value = singleValue;
                } else {
                    value += "&" + singleValue;
                }
            }
            return value ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }


    public Map<String, MessageDTO> getMessageDTO() {
        return messageDTO;
    }

    public void setMessageDTO(Map<String, MessageDTO> messageDTO) {
        this.messageDTO = messageDTO;
    }

    @Override
    public String toString() {
        return "DevStatusMessageDTO{" +
                "devtype='" + devtype + '\'' +
                ", status='" + status + '\'' +
                ", alarmId=" + alarmId +
                ", sournd='" + sournd + '\'' +
                ", code=" + code +
                ", tel=" + tel +
                '}';
    }
}
