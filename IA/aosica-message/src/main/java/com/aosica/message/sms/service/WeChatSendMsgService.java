package com.aosica.message.sms.service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aosica.common.exception.AosicaException;
import com.aosica.message.sms.config.*;
import com.aosica.message.sms.entity.MsgResponse;
import com.aosica.message.sms.entity.TemplateEntity;
import com.aosica.message.sms.entity.TemplateParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ai-planting->WeChatSendMsgService
 * @description: 微信推送消息
 * @author: dwj
 * @create: 2019-09-18 09:52
 **/
@Service
public class WeChatSendMsgService {

    public MsgResponse sendMsg(String title,String content,String sendTime){
        MsgResponse msgResponse = new MsgResponse();
        //获取缓存中存的access_token
        String accessToken =  CacheUtil.get("access_token",String.class);
        if(StringUtils.isBlank(accessToken)){
            AccessTokenThread.getAccessToken();
        }
        try {
            String templateMsgUrl = WeiXinConfig.templateMsgUrl;
            templateMsgUrl = templateMsgUrl.replace("ACCESS_TOKEN", accessToken);
            //封装请求体
            TemplateEntity template = new TemplateEntity();
            template.setTemplateId(WeiXinConfig.templateId);
            List<TemplateParam> templateParams = new ArrayList<TemplateParam>();
            TemplateParam first = new TemplateParam("first", title + "\\r\\n", "#DB1A1B");
            TemplateParam keyword1 = new TemplateParam("keyword1", content + "\\r\\n", "#DB1A1B");
            TemplateParam keyword2 = new TemplateParam("keyword2",  "", "#DB1A1B");
            TemplateParam keyword3 = new TemplateParam("keyword3", sendTime, "#DB1A1B");
            TemplateParam remark = new TemplateParam("remark", content, "#DB1A1B");
            templateParams.add(first);
            templateParams.add(keyword1);
            templateParams.add(keyword2);
            templateParams.add(keyword3);
            templateParams.add(remark);
            template.setTpParamList(templateParams);
            List<String> openList = this.recursionOpenId(null);
                for(String id :openList){
                    template.setToUser(id);//要推送的用户openid
                    String paramStr = JSONObject.toJSONString(template);
                    String resJson = HttpClientUtil.doTemplateMsgPost(templateMsgUrl, paramStr);

                }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            msgResponse.setCode(String.valueOf(Constant.FAIL));
        }
        return msgResponse;
    }

    /**
     * @desc 递归查询openId,一次最多拉取10000各个关注者的OpenId,可以多次拉取满足需求
     * @return List<String>
     */
    public List<String> recursionOpenId(String nextOpenId){
        List<String> ids = new ArrayList<String>();
        try {
            //获取缓存中存的access_token
            String accessToken =  CacheUtil.get("access_token",String.class);
            if(StringUtils.isBlank(accessToken)){
                AccessTokenThread.getAccessToken();
            }
            String resultInfo = HttpClientUtil.doGet(WeiXinConfig.getOpen_id_url(accessToken,nextOpenId));
            JSONObject obj =  JSONObject.parseObject(resultInfo);
            JSONObject dataObj  =JSONObject.parseObject(obj.getString("data"));
            JSONArray arryList = dataObj.getJSONArray("openid");
            String newNextOpenId = obj.getString("next_openid");
            if(arryList.size() > 0){
                for(int i=0;i<arryList.size();i++){
                    String openid = arryList.getString(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                    ids.add(openid);
                }
            }
            if(ids.size()>10000){
                recursionOpenId(newNextOpenId);
            }
        } catch (Exception e) {
           throw new AosicaException("获取所有关注的openid异常"+e.getMessage());
        }
        return ids;
    }
}
