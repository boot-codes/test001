package com.aosica.agriculture.api.fallback;


/**
 * @program: ai-planting->WeatherDeviceManagerFallBack
 * @description:
 * @author: dwj
 * @create: 2019-09-07 10:01
 **/
//@Component
//public class WeatherDeviceManagerFallBack implements FallbackFactory<WeatherDeviceManagerApi> {
//
//    @Override
//    public WeatherDeviceManagerApi create(Throwable throwable) {
//        return new WeatherDeviceManagerApi(){
//            @Override
//            public List<WeatherDevice> getDeviceList(String projectId) {
//                List<WeatherDevice> list = new ArrayList<WeatherDevice>();
//                WeatherDevice weatherDevice = new WeatherDevice();
//                weatherDevice.setDeviceId("123");
//                weatherDevice.setProjectId("00000");
//                weatherDevice.setHumidity(75.7f);
//                weatherDevice.setTemperature(26.7f);
//                weatherDevice.setWindSpeed(0.3);
//                weatherDevice.setAtmosphericPressure(917.8f);
//                weatherDevice.setCollectorDate(new Date());
//                weatherDevice.setRainfall(60f);
//                weatherDevice.setIllumination(0f);
//                weatherDevice.setWindDirection(30f);
//                list.add(weatherDevice);
//                return list;
//            }
//        };
//    }
//}
