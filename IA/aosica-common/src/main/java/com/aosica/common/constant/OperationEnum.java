package com.aosica.common.constant;

/**
 * @program: ai-planting->OperationEnum
 * @description: 日志枚举类
 * @author: dwj
 * @create: 2019-08-30 17:26
 **/
public enum OperationEnum {

    DEFAULT(0, "默认"),
    ADD(1, "新增"),
    UPDATE(2, "修改"),
    DELETE(3, "删除"),
    VIEW(4, "查看"),
    EQUIPMENT_ERASURE(5, "设备消音"),
    EQUIPMENT_WARN_HANDLING(6, "设备报警处理"),
    FAULT_HANDLING(7, "故障处理"),
    OFF_LINE_HANDLING(8, "离线处理");


    private  int value  = 0;;

    private  String label = null;

     OperationEnum(int value, String label) {
        this.value = value;
        this.label = label;
    }


    /**
     * @description 是否包含该枚举值
     * @param type
     * @return
     */
    public static boolean contain(Integer type) {
        OperationEnum[] types = OperationEnum.values();
        if (type == null) {
            return false;
        }
        for (OperationEnum ete : types) {
            if (ete.getValue() == type.intValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean notContain(Integer type) {
        return !contain(type);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
