package com.aosica.lot.dto;


/**
 *   todo 气象数据 实体类
 *   风速  m/s
 *   风向
 *   温度
 *   湿度 %
 *   大气压压力
 *   风速(2.14)     风向(140.20)       温度(31.28)    湿度(62.76) 大气压力(990.90)
 */
public class WeatherDeviceDataDTO {

    /**
     * 风速  m/s
     */
    private Float windSpeed;

    /**
     * 风向
     */
    private Float windDirection;

    /**
     * 温度
     */
    private Float temperature;

    /**
     * 湿度
     */
    private Float humidity ;

    /**
     * 大气压压力
     */
    private Float atmosphericPressure;



    public static  WeatherDeviceDataDTO buildObject(String hexString) {
        WeatherDeviceDataDTO weatherDeviceData = new WeatherDeviceDataDTO() ;
        Integer temp_windSpeed= Integer.valueOf(hexString.substring(6, 10), 16);
        System.out.println(temp_windSpeed);
        weatherDeviceData.windSpeed = (Integer.valueOf(hexString.substring(6, 10), 16)) / 10.00f ;

        Integer temp_windDirection = Integer.valueOf(hexString.substring(10, 14), 16);
        System.out.println(temp_windDirection);
        weatherDeviceData.windDirection = Integer.valueOf(hexString.substring(10,14), 16) /10.00f;
        weatherDeviceData.temperature = Integer.valueOf(hexString.substring(14, 18), 16)/10.00f ;
        weatherDeviceData.humidity = Integer.valueOf(hexString.substring(18, 22), 16)/10.00f ;
        weatherDeviceData.atmosphericPressure = Integer.valueOf(hexString.substring(22, 26), 16)/10.00f ;

        return  weatherDeviceData ;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Float windDirection) {
        this.windDirection = windDirection;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(Float atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    @Override
    public String toString() {
        return "WeatherDeviceDataDTO{" +
                "windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", atmosphericPressure=" + atmosphericPressure +
                '}';
    }

    public static void main(String[] args) {
        WeatherDeviceDataDTO machineUtil = WeatherDeviceDataDTO.buildObject("01031400030ADF010B02F523DA0000000000000000000065F2");
        System.out.println(machineUtil);
//        System.out.println(machineUtil.getRange());
//        System.out.println(machineUtil.getTemperature());
//        System.out.println(machineUtil.getCentigrade());
//        System.out.println(machineUtil.getRh());
//        System.out.println(machineUtil.gethPa());
    }

}
