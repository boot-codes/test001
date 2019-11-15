package com.aosica.lot.entity;

import java.util.Date;

/**
 * 智慧农业设备测量数据实体类
 */
public class DeviceData {



    private Long id;

    /**
     * 工程id
     */
    private String projectId;


    /**
     * 网关 id
     */
    private String gatewayId;


    /**
     * 设备id
     */
    private String deviceId;


    /**
     * 设备类型
     */
    private String deviceModel;


    /**
     * 风速
     */
    private Float winds;

    /**
     * 风向
     */
    private Float windD;


    /**
     * 空气湿度
     */
    private Float airH;


    /**
     *  空气温度
     */
    private Float airT;


    /**
     * 光照度
     */
    private Float ill;


    /**
     * 大气压力
     */
    private Float atm;

    /**
     * 降雨量
     */
    private Float rainF;

    /**
     * 土壤湿度
     */
    private Float soilH;

    /**
     *  土壤温度
     */
    private Float soilT;

    /**
     *  土壤电导率
     */
    private Float soilC;

    /**
     * 土壤盐分
     */
    private Float soilS;


    /**
     * 干式PH值
     */
    private Float dPH;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Float getWinds() {
        return winds;
    }

    public void setWinds(Float winds) {
        this.winds = winds;
    }

    public Float getWindD() {
        return windD;
    }

    public void setWindD(Float windD) {
        this.windD = windD;
    }

    public Float getAirH() {
        return airH;
    }

    public void setAirH(Float airH) {
        this.airH = airH;
    }

    public Float getAirT() {
        return airT;
    }

    public void setAirT(Float airT) {
        this.airT = airT;
    }

    public Float getIll() {
        return ill;
    }

    public void setIll(Float ill) {
        this.ill = ill;
    }

    public Float getAtm() {
        return atm;
    }

    public void setAtm(Float atm) {
        this.atm = atm;
    }

    public Float getRainF() {
        return rainF;
    }

    public void setRainF(Float rainF) {
        this.rainF = rainF;
    }

    public Float getSoilH() {
        return soilH;
    }

    public void setSoilH(Float soilH) {
        this.soilH = soilH;
    }

    public Float getSoilT() {
        return soilT;
    }

    public void setSoilT(Float soilT) {
        this.soilT = soilT;
    }

    public Float getSoilC() {
        return soilC;
    }

    public void setSoilC(Float soilC) {
        this.soilC = soilC;
    }

    public Float getSoilS() {
        return soilS;
    }

    public void setSoilS(Float soilS) {
        this.soilS = soilS;
    }

    public Float getdPH() {
        return dPH;
    }

    public void setdPH(Float dPH) {
        this.dPH = dPH;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "DeviceData{" +
                "id=" + id +
                ", projectId='" + projectId + '\'' +
                ", gatewayId='" + gatewayId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", winds=" + winds +
                ", windD=" + windD +
                ", airH=" + airH +
                ", airT=" + airT +
                ", ill=" + ill +
                ", atm=" + atm +
                ", rainF=" + rainF +
                ", soilH=" + soilH +
                ", soilT=" + soilT +
                ", soilC=" + soilC +
                ", soilS=" + soilS +
                ", dPH=" + dPH +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}