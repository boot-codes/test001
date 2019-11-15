package com.aosica.common.constant;



/**
 * @category 设备状态:
 * 正常:1
 * 失联:2
 * 告警:3
 * 故障:4
 * @author yuzp
 *
 */
public enum DeviceStateEnum {

	/**
	 * 正常 normal
	 */
	DEVICE_STATE_normal(1, "正常"), //normal
	/**
	 * 失联 offLine
	 */
	DEVICE_STATE_offLine(2, "失联"),// offLine
	/**
	 * 告警  alarm
	 */
	DEVICE_STATE_alarm(3, "告警"), //alarm
	/**
	 * 故障  fault
	 */
	DEVICE_STATE_fault(4, "故障");//fault

	private int key;

	private String value;

	private DeviceStateEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @category 根据key获取对应的value值
	 * @param key
	 * @return
	 */
	public static String getValues(int key) {
		for (DeviceStateEnum enums : DeviceStateEnum.values()) {
			if (key == enums.getKey()) {
				return enums.getValue();
			}
		}
		return null;
	}

	/**
	 * @category 根据value获取对应的key值
	 * @param
	 * @return
	 */
	public static Integer getkeys(String value) {
		for (DeviceStateEnum enums : DeviceStateEnum.values()) {
			if (value.equals(enums.getValue())) {
				return enums.getKey();
			}
		}
		return null;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
