package com.allen.keep.redis_shizhan.util;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * @descript 发短信
 * @author allen
 * @date 2020-05-01 9:08 PM
 */
public class Message {

    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G1XywR6opp5rq6nssUB", "");
        IAcsClient client = new DefaultAcsClient(profile);

        // 封装请求参数
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        // 必传参数 手机号，签名名称，模版号
        request.putQueryParameter("PhoneNumbers", "");
        request.putQueryParameter("SignName", "峰峰爱学习");
        request.putQueryParameter("TemplateCode", "SMS_189610785");

        // 模版里的参数
        Map map = new HashMap();
        map.put("code","666666");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
