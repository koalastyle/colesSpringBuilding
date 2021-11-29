package com.example.colesspringbuilding.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.colesspringbuilding.pojo.OutGeocodesPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class demoController {
    @Value("${app.secret-key:}")
    private String secretKey;

    private static final String URL = "https://restapi.amap.com/v3/geocode/geo";

    @RequestMapping("/hello")
    public Object hello() throws Exception {
        if (StrUtil.isBlank(secretKey)) {
            throw new Exception("未配置高德地图开发平台密钥");
        }
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("address", "成都市电子科技大学|四川大学");
        inParams.put("key", secretKey);
        inParams.put("batch", "true");
        String response = HttpUtil.get(URL, inParams);
        OutGeocodesPojo out = new OutGeocodesPojo();
        out = JSON.parseObject(response, OutGeocodesPojo.class);
        JSONObject json = JSON.parseObject(response);
        System.out.println(json.toString(SerializerFeature.PrettyFormat));
        return out;
    }
}
