package com.aosica.common.constant;


/**
 * 设备运行状态enum
 */
public enum DeviceStatusEnum {

	NORMAL(1, "正常"),
	FAILURE(2, "故障"),
	ALARM(3, "报警"),
	FALSE_POSITIVE(4, "误报"),
	SENTRIES(5, "查岗"),
	LOSE_CONNECTION(6, "失去连接");


	private int code;

	private String desc;

	DeviceStatusEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static String getDescByCode(int code) {
		for (DeviceStatusEnum appCode : DeviceStatusEnum.values()) {
			if (appCode.getCode() == code) {
				return appCode.getDesc();
			}
		}
		return "";
	}

}
