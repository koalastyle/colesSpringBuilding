package com.example.colesspringbuilding.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        InParamsGeoCoding params = new InParamsGeoCoding();


        params.setKey(secretKey);
        System.out.println("secretKey="+secretKey);
        params.setAddress("四川省成都市博物馆");

        return null;
    }

    JSONObject getJson(InParamsGeoCoding o){
        Object obj =  JSON.toJSON(o);
        JSONObject json = JSON.parseObject(obj.toString());
        return json;
    }
}
