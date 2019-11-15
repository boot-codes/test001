package com.aosica.message.sms.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: ai-planting->TemplateEntity
 * @description: 模板消息
 * @author: dwj
 * @create: 2019-09-17 17:37
 **/
@Data
public class TemplateEntity {

    /**
     *@Fields 消息接收方
     */
    private String toUser;
    /**
     * @Fields 模板Id
     */
    private String templateId;
    /**
     * @Fields 模板消息详情链接
     */
    private String url;
    /**
     * @Fields 参数列表
     */
    private List<TemplateParam> tpParamList;




    @Override
    public String toString() {
        return "TemplateEntity{" +
                "toUser='" + toUser + '\'' +
                ", templateId='" + templateId + '\'' +
                ", url='" + url + '\'' +
                ", tpParamList=" + tpParamList +
                '}';
    }

    public String toJson(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append(String.format("\"toUser\":\"%s\"",this.toUser)).append(",");
        buffer.append(String.format("\"template_id\":\"%s\"",this.templateId)).append(",");
        buffer.append("\"data\":{");
        TemplateParam param = null;
        for (int i = 0; i < this.tpParamList.size(); i++) {
            param = tpParamList.get(i);
            // 判断是否追加逗号
            if (i < this.tpParamList.size() - 1) {

                buffer.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"},", param.getName(), param.getValue(), param.getColor()));
            } else {
                buffer.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"}", param.getName(), param.getValue(), param.getColor()));
            }

        }
        buffer.append("}");
        buffer.append("}");
        return buffer.toString();
    }
}
