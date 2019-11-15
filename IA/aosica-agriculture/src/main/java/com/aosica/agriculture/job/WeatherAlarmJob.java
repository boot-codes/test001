package com.aosica.agriculture.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aosica.common.exception.AosicaException;
import com.aosica.common.util.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: ai-planting->WeatherAlarmJob
 * @description: 天气预警定时任务
 * @author: Windows10
 * @create: 2019-08-27 09:42
 **/
@Component
public class WeatherAlarmJob {
    private Logger logger = LoggerFactory.getLogger(WeatherAlarmJob.class);

    //获取所有的天气预警数据
    private static  String alarmDataUrl = "http://product.weather.com.cn/alarm/grepalarm_cn.php";
    //获取具体地方天气预警数据
    private static String alarmDataInfoUrl = "http://product.weather.com.cn/alarm/webdata/";

    @Scheduled(cron = "0 0,6,12,14,18,20,23 * * ?")
    public void execute(){
        logger.info("天气预警定时任务start............");
        List<Map<String,String>> list = getWeatherAlarmData();
        logger.info("获取的天气预警数据{}"+JSONObject.toJSONString(list));

    }

    /**
     * @description 调用天气预警接口获取数据
     * @return  List<Map<String,String>>
     */
    private static List<Map<String,String>> getWeatherAlarmData(){
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        try{
            String result = HttpRequest.sendGet(alarmDataUrl,"");
            result = result.substring(result.indexOf("{"));
            result = result.substring(0,result.lastIndexOf(";"));
            JSONObject jsonObject = JSONObject.parseObject(result);
            JSONArray dataList = (JSONArray) jsonObject.get("data");
            for(int i=0;i<dataList.size();i++){
                JSONArray strList = (JSONArray)dataList.get(i);
                String url = (String) strList.get(1);
                String msg = HttpRequest.sendGet(alarmDataInfoUrl+url,"");
                msg = msg.substring(msg.indexOf("{"));
                JSONObject json = JSONObject.parseObject(msg);
                String head = (String)json.get("head");
                String province = (String)json.get("PROVINCE");
                String city = (String)json.get("CITY");
                String area = (String)json.get("STATIONNAME");
                String alarmType = (String)json.get("SIGNALTYPE");
                String levelColor = (String)json.get("SIGNALLEVEL");
                String level  = (String)json.get("LEVELCODE");
                String alarmTime = (String)json.get("ISSUETIME");
                String content = (String)json.get("ISSUECONTENT");

            }
        }catch (Exception e){
            throw new AosicaException("调用天气预警数据异常"+e.getMessage(),e);
        }
        return list;
    }
}
