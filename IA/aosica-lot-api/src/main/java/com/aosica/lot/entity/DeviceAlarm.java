package com.aosica.lot.entity;

import java.util.Date;


/**
 * 设备告警实体类
 */
public class DeviceAlarm {

    private Long id;

    private Long deviceId;

    private Integer alarmType;

    private String alarmItem;

    private String alarmValue;

    private String alarmReason;

    private String collectionTime;

    private Integer isHandle;

    private String handelResult;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmItem() {
        return alarmItem;
    }

    public void setAlarmItem(String alarmItem) {
        this.alarmItem = alarmItem == null ? null : alarmItem.trim();
    }

    public String getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(String alarmValue) {
        this.alarmValue = alarmValue == null ? null : alarmValue.trim();
    }

    public String getAlarmReason() {
        return alarmReason;
    }

    public void setAlarmReason(String alarmReason) {
        this.alarmReason = alarmReason == null ? null : alarmReason.trim();
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime == null ? null : collectionTime.trim();
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public String getHandelResult() {
        return handelResult;
    }

    public void setHandelResult(String handelResult) {
        this.handelResult = handelResult == null ? null : handelResult.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    @Override
    public String toString() {
        return "DeviceAlarm{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", alarmType=" + alarmType +
                ", alarmItem='" + alarmItem + '\'' +
                ", alarmValue='" + alarmValue + '\'' +
                ", alarmReason='" + alarmReason + '\'' +
                ", collectionTime='" + collectionTime + '\'' +
                ", isHandle=" + isHandle +
                ", handelResult='" + handelResult + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}