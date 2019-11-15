package com.aosica.lot.dto;

import java.util.HashMap;

/**
 * @PackgeName com.aosica.netty.mqtt
 * @ClassName MqttProtocolMap.java
 * @Description: TODO
 * @Author: yuzp
 * @Date: 2019/9/9 16:10
 * @UpdateUser: yuzp
 * @UpdateDate: 2019/9/9$ 16:10$
 * @UpdateRemark: TODO
 * @Version: 1.0
 */
public class MqttProtocolMap {

    public final  static HashMap<String,MqttMeasuredData> map = new HashMap<>() ;


    static {


        /**
         * 空气湿度  airH 0~100 0.1 %
         */
        map.put("airH",new MqttMeasuredData("空气湿度","airH",0.1f,"%")) ;

        /**
         * 空气温度 airT -40~80 0.1 ℃
         */
        map.put("airT",new MqttMeasuredData("空气温度","airH",0.1f,"℃")) ;


        /**
         * 光照度 ill 0~200000或0~65535 1 Lux
         */
        map.put("ill",new MqttMeasuredData("光照度","ill",1f,"Lux")) ;


        /**
         * 土壤湿度 soilH 0~100 0.1 %
         */
        map.put("soilH",new MqttMeasuredData("土壤湿度","soilH",0.1f,"%")) ;


        /**
         * 土壤温度 soilT -40~80 0.1 ℃
         */


        /**
         * 土壤电导率 soilC 0~10000 1 uS/cm
         */



        /**
         * 二氧化碳浓度 co2 0~10000 1 ppm
         */



        /**
         * 干式PH值 dPH 0~14 0.1
         */


        /**
         * 风速 windS 0 ~30 0.1 m/s
         */

        /**
         * 风向 windD 0 ~360 0.1 度
         */


        /**
         * 大气压力 atm 300 ~1100 0.1 hPa
         */
        map.put("atm",new MqttMeasuredData("大气压力","soilH",0.1f,"hPa")) ;


        /**
         * 降雨量 rainF 0 ~ 32766 0.2 mm
         */


        /**
         * 日照时数 sDur 0~1440 1 小时
         */


        /**
         * 蒸发量 eCap 0~80 0.01 mm
         */

        /**
         * TBQ总辐射 TBQ 0~2000 1 w/m2
         */

        /**
         * 光合有效辐射 PAR 0~2000 1 w/m2
         */


        /**
         * 湿式PH值 wPH 0~14 0.01
         */

        /**
         * 液位 level 0~10000 1 cm
         */

        /**
         * 液体电导率 LiquidC 0~20000 1 uS/cm
         */

        /**
         * 液体压力 LiquidP 0~20000 1 kpa
         */

        /**
         *  PM2.5 pm25 0~1000 1 ug/m3
         */

        /**
         * 雨雪传感器 sleet 0(无雨雪)或1(有雨雪) 1
         */

        /**
         * 土壤盐分 soilS 0~10000 1 ppm
         */

        /**
         * PM10 pm10 0~1000 1 ug/m3
         */

        /**
         * 紫外线传感器 UV 0~300 0.1 W/m3
         */

        /**
         * 叶面湿度 leafH 0~100 0.1 %
         */

        /**
         * 叶面温度 leafT -40~80 0.1 ℃
         */


        /**
         * 二氧化硫 SO2 0~20 0.01 ppm
         */


        /**
         * 噪声 noise 30~130 0.1 dB
         */

        /**
         * 氨氮 NH3N 0~1000 0.1 mg/L
         */

        /**
         * 水温 LiquidT -40~80 0.1 ℃
         */

        /**
         * 氨气 NH3 0~1000 1 ppm
         */

        /**
         * 溶解氧 DO 0~500 0.01 mg/L
         */



    }

    /**
     * 传感器 sensorType 量程 分辨率 单位
     */
    static class MqttMeasuredData{

        // 传感器名称
        private String sensorName ;

        // sensorType
        private String sensorType;

        // 分辨率
        private float dpi ;

        //单位
        private String unit ;


        public MqttMeasuredData(String sensorName, String sensorType, float dpi, String unit) {
            this.sensorName = sensorName;
            this.sensorType = sensorType;
            this.dpi = dpi;
            this.unit = unit;
        }

        public String getSensorName() {
            return sensorName;
        }

        public void setSensorName(String sensorName) {
            this.sensorName = sensorName;
        }

        public String getSensorType() {
            return sensorType;
        }

        public void setSensorType(String sensorType) {
            this.sensorType = sensorType;
        }

        public float getDpi() {
            return dpi;
        }

        public void setDpi(float dpi) {
            this.dpi = dpi;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return "MqttData{" +
                    "sensorName='" + sensorName + '\'' +
                    ", sensorType='" + sensorType + '\'' +
                    ", dpi=" + dpi +
                    ", unit='" + unit + '\'' +
                    '}';
        }
    }
}
