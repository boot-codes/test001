package com.aosica.common.constant;


/**
 * @PackgeName com.aosica.common.util
 * @ClassName ServiceTypeEnum.java
 * @Description: 服务名称
 * @Author: ylp
 * @Date: 2019/8/21 17:00
 * @UpdateUser: ylp
 * @UpdateDate: 2019/8/21$ 17:00$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public enum ServiceTypeEnum {

	DATA_TYPE_1(1, "云平台"),
	DATA_TYPE_2(2, "三小平台"),
	DATA_TYPE_401(401, "上海技术平台"),
	DATA_TYPE_402(402, "山东技术平台"),
	DATA_TYPE_403(403, "南宁技术平台"),
	DATA_TYPE_404(404, "深圳南山");

	private int key;
	private String value;

	private ServiceTypeEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @category 根据key获取对应的value值
	 * @param key
	 * @return
	 */
	public static String getValues(int key) {
		String values = null;
		for (ServiceTypeEnum keys : ServiceTypeEnum.values()) {
			values = (key == keys.getKey()) ? keys.getValue() : null;
		}
		return values;
	}

	/**
	 * @category 根据value获取对应的key值
	 * @return
	 */
	public static Integer getkeys(String value) {
		Integer keys = null;
		for (ServiceTypeEnum values : ServiceTypeEnum.values()) {
			keys = value.equals(values.getValue()) ? values.getKey() : null;
		}
		return keys;
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
