package com.aosica.lot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 *  设备系统类型
 */
@ApiModel(description = "设备系统类型实体类")
public class DeviceSystemType {


    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "工程id")
    private Long projectId;

    @ApiModelProperty(value = "系统类型名称")
    private String systemTypeName;

    @ApiModelProperty(value = "系统类型编码")
    private String systemTypeCode;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private Long creater;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private Long updater;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getSystemTypeName() {
        return systemTypeName;
    }

    public void setSystemTypeName(String systemTypeName) {
        this.systemTypeName = systemTypeName == null ? null : systemTypeName.trim();
    }

    public String getSystemTypeCode() {
        return systemTypeCode;
    }

    public void setSystemTypeCode(String systemTypeCode) {
        this.systemTypeCode = systemTypeCode == null ? null : systemTypeCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    @Override
    public String toString() {
        return "DeviceSystemType{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", systemTypeName='" + systemTypeName + '\'' +
                ", systemTypeCode='" + systemTypeCode + '\'' +
                ", createTime=" + createTime +
                ", creater=" + creater +
                ", updateTime=" + updateTime +
                ", updater=" + updater +
                '}';
    }
}