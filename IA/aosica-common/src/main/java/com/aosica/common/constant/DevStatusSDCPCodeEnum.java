package com.aosica.common.constant;

import java.util.HashMap;
import java.util.Map;

public enum DevStatusSDCPCodeEnum {

	DEV_STATUS_SDCP_NORMAL(0, "正常"),

	// 以下字段是各种设备报警的字段 报警状态 开始
	DEV_STATUS_SDCP_ALARM(1, "报警"), 
	DEV_STATUS_SDCP_CONTINGENCY(2, "应急"),
	DEV_STATUS_SDCP_LOW_PRESSURE_ALARM(3, "低压告警"), 
	DEV_STATUS_SDCP_HIGH_PRESSURE_ALARM(4, "高压告警"),
	DEV_STATUS_SDCP_FALSE_POSITIVE(7, "误报"), 
	DEV_STATUS_SDCP_LOW_WATER(5, "低水位告警"),
	DEV_STATUS_SDCP_HIGH_WATER(6, "高水位告警"), 
	DEV_STATUS_SDCP_FAILURE_WARNING(9, "故障,报警"),
	DEV_STATUS_SDCP_OVERCURRENT(10, "负载电流报警"), 
	DEV_STATUS_SDCP_SHORT(11, "短路"),
	DEV_STATUS_SDCP_HYPERPYREXIA1(12, "温度1告警"), 
	DEV_STATUS_SDCP_HYPERPYREXIA2(18, "温度2告警"),
	DEV_STATUS_SDCP_HYPERPYREXIA3(19, "温度3告警"), 
	DEV_STATUS_SDCP_OVERVOLTAGE(15, "电压过压报警"),
	DEV_STATUS_SDCP_UNDERVOLTAGE(16, "电压欠压报警"), 
	DEV_STATUS_SDCP_RESIDUAL_CURRENT(17, "剩余电流超限报警"),
	DEV_STATUS_SDCP_LOW_ALARM(30, "低告警"), 
	DEV_STATUS_SDCP_HIGH_ALARM(31, "高告警"),
	DEV_STATUS_SDCP_LOW_HIGH_ALARM(32, "低、高告警"), 
	DEV_STATUS_ALARM_PH(135, "PH超标报警"), 
	DEV_STATUS_ALARM_CODCR(400, "化学需氧量超标报警"), 
	DEV_STATUS_ALARM_CR(401, "总铬超标报警"),
	DEV_STATUS_ALARM_SIXCR(402, "六价铬超标报警"), 
	DEV_STATUS_ALARM_NI(403, "总镍超标报警"), 
	DEV_STATUS_ALARM_CU(404, "总铜超标报警"),
	DEV_STATUS_ALARM_ZN(405, "总锌超标报警"), 
	DEV_STATUS_ALARM_BOD(406, "氨氮超标报警"), 
	DEV_STATUS_ALARM_P(407, "总磷超标报警"), 
	
	DEV_STATUS_FAILURE_PH(-135, "PH探测器故障"), 
	DEV_STATUS_FAILURE_CODCR(-400, "化学需氧量探测器故障"),
	DEV_STATUS_FAILURE_CR(-401, "总铬探测器故障"), 
	DEV_STATUS_FAILURE_SIXCR(-402, "六价铬探测器故障"),
	DEV_STATUS_FAILURE_NI(-403, "总镍探测器故障"), 
	DEV_STATUS_FAILURE_CU(-404, "总铜探测器故障"),
	DEV_STATUS_FAILURE_ZN(-405, "总锌探测器故障"), 
	DEV_STATUS_FAILURE_BOD(-406, "氨氮探测器故障"),
	DEV_STATUS_FAILURE_P(-407, "总磷探测器故障"), 
	
	DEV_STATUS_SDCP_UNCONFIRM_ALARM(8, "未确认火警"),
	// 报警状态 结束

	DEV_STATUS_SDCP_FAILURE(-1, "故障"), 
	DEV_STATUS_SDCP_COMMUNICATE_FAILURE(-2, "通信故障"),
	DEV_STATUS_SDCP_SENSOR_FAILURE(-3, "传感器故障"), 
	DEV_STATUS_SDCP_DIFFER(-4, "采集电话卡IMSI与登记不一致"),
	DEV_STATUS_SDCP_LOSE_CONNECTION(-5, "失去连接"), 
	DEV_STATUS_SDCP_BATTERY(-6, "电池故障"), 
	DEV_STATUS_SDCP_LIGHT(-7, "光源故障"), 
	DEV_STATUS_SDCP(-8, "主电故障"), 
	DEV_STATUS_SDCP_NOT_EXIST(-100, "不存在"), 
	DEV_STATUS_SDCP_FORBID(-101, "被禁用"), 
	DEV_STATUS_SDCP_INIT(-102, "初始化"), 
	DEV_STATUS_SDCP_POWER_OUTAGE(-103, "断电");

	// 编码
	private int code;
	// 描述
	private String desc;
	// 状态分类
	public static Map<Integer, Integer> mapType = new HashMap<Integer, Integer>();

	private DevStatusSDCPCodeEnum(int code, String desc) {
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
		for (DevStatusSDCPCodeEnum appCode : DevStatusSDCPCodeEnum.values()) {
			if (appCode.getCode() == code) {
				return appCode.getDesc();
			}
		}
		return "";
	}
	
	static {
		// 正常
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_NORMAL.getCode(), DeviceStateEnum.DEVICE_STATE_0.getKey());
//		// 报警
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_ALARM.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_CONTINGENCY.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_LOW_PRESSURE_ALARM.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_HIGH_PRESSURE_ALARM.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_FALSE_POSITIVE.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_LOW_WATER.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_HIGH_WATER.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_FAILURE_WARNING.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_OVERCURRENT.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_SHORT.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_HYPERPYREXIA1.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_HYPERPYREXIA2.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_HYPERPYREXIA3.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_OVERVOLTAGE.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_UNDERVOLTAGE.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_RESIDUAL_CURRENT.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_LOW_ALARM.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_HIGH_ALARM.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_LOW_HIGH_ALARM.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_PH.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_CODCR.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_CR.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_SIXCR.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_NI.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_CU.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_ZN.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_BOD.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_ALARM_P.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_PH.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_CODCR.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_CR.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_SIXCR.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_NI.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_CU.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_ZN.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_BOD.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_FAILURE_P.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_UNCONFIRM_ALARM.getCode(), DeviceStateEnum.DEVICE_STATE_2.getKey());
//		// 故障
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_FAILURE.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_COMMUNICATE_FAILURE.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_SENSOR_FAILURE.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_DIFFER.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_LOSE_CONNECTION.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_BATTERY.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_LIGHT.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_NOT_EXIST.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_FORBID.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_INIT.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
//		mapType.put(DevStatusSDCPCode.DEV_STATUS_SDCP_POWER_OUTAGE.getCode(), DeviceStateEnum.DEVICE_STATE_3.getKey());
	}
	
	public static Integer getDeviceStuts(Integer key) {
		for (Map.Entry<Integer, Integer> entry : mapType.entrySet()) {
			if (key.equals(entry.getKey())) {
				return entry.getValue();
			}
		}
		return null;
	}

}
