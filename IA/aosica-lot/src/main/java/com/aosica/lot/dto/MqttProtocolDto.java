package com.aosica.lot.dto;

import java.util.Date;

/**
 * @PackgeName com.aosica.netty.mqtt
 * @ClassName MqttDto.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/9 15:15
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/9$ 15:15$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class MqttProtocolDto {



    private String id ;

    /**
     * 空气湿度  airH 0~100 0.1 %
     */
    private float airH  ;

    /**
     * 空气温度 airT -40~80 0.1 ℃
     */
    private float airT ;


    /**
     * 大气压力 atm 300 ~1100 0.1 hPa
     */
    private float atm ;


    /**
     * 降雨量 rainF 0 ~ 32766 0.2 mm
     */
    private float rainF ;


    /**
     * 风速 windS 0 ~30 0.1 m/s
     */
    private float windS ;

    /**
     * 风向 windD 0 ~360 0.1 度
     */
    private float windD ;

    /**
     * 土壤湿度 soilH 0~100 0.1 %
     */
    private float soilH ;

    /**
     * 土壤温度 soilT -40~80 0.1 ℃
     */
    private float soilT ;

    /**
     * 土壤电导率 soilC 0~10000 1 uS/cm
     */
    private float soilC ;

    /**
     * 土壤盐分 soilS 0~10000 1 ppm
     */
    private float soilS ;


    /**
     * 干式PH值 dPH 0~14 0.1
     */
    private float dPH ;


    /**
     * 光照度 ill 0~200000或0~65535 1 Lux
     */
    private float ill ;

    /**
     * 创建时间
     */
    private Date createDate  = new Date() ;

    private String gateWayId ;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    //    public void setAirH(float airH) {
//        MqttProtocolMap.MqttMeasuredData data = MqttProtocolMap.map.get("airH");
//        float dpi = (data.getDpi()==0.2f?0.1f:data.getDpi());
//        this.airH = airH*dpi;
//    }


    public float getAirH() {
        return airH;
    }

    public void setAirH(float airH) {
        this.airH = airH;
    }

    public float getAirT() {
        return airT;
    }

    public void setAirT(float airT) {
        this.airT = airT;
    }

    public float getAtm() {
        return atm;
    }

    public void setAtm(float atm) {
        this.atm = atm;
    }

    public float getRainF() {
        return rainF;
    }

    public void setRainF(float rainF) {
        this.rainF = rainF;
    }

    public float getWindS() {
        return windS;
    }

    public void setWindS(float windS) {
        this.windS = windS;
    }

    public float getWindD() {
        return windD;
    }

    public void setWindD(float windD) {
        this.windD = windD;
    }

    public float getSoilH() {
        return soilH;
    }

    public void setSoilH(float soilH) {
        this.soilH = soilH;
    }

    public float getSoilT() {
        return soilT;
    }

    public void setSoilT(float soilT) {
        this.soilT = soilT;
    }

    public float getSoilC() {
        return soilC;
    }

    public void setSoilC(float soilC) {
        this.soilC = soilC;
    }

    public float getSoilS() {
        return soilS;
    }

    public void setSoilS(float soilS) {
        this.soilS = soilS;
    }

    public float getdPH() {
        return dPH;
    }

    public void setdPH(float dPH) {
        this.dPH = dPH;
    }

    public float getIll() {
        return ill;
    }

    public void setIll(float ill) {
        this.ill = ill;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public String getGateWayId() {
        return gateWayId;
    }

    public void setGateWayId(String gateWayId) {
        this.gateWayId = gateWayId;
    }

    @Override
    public String toString() {
        return "MqttProtocolDto{" +
                "id='" + id + '\'' +
                ", airH=" + airH +
                ", airT=" + airT +
                ", atm=" + atm +
                ", rainF=" + rainF +
                ", windS=" + windS +
                ", windD=" + windD +
                ", soilH=" + soilH +
                ", soilT=" + soilT +
                ", soilC=" + soilC +
                ", soilS=" + soilS +
                ", dPH=" + dPH +
                ", ill=" + ill +
                ", createDate=" + createDate +
                ", gateWayId='" + gateWayId + '\'' +
                '}';
    }
}
