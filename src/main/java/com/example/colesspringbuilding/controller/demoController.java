package com.example.colesspringbuilding.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.pojo.In.InPojo;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.Out.params.OutParamsGeoCoding;
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
        InPojo in = new InPojo();
        in.setUrl("https://restapi.amap.com/v3/geocode/geo");

        params.setKey(secretKey);
        System.out.println("secretKey="+secretKey);
        params.setAddress("四川省成都市博物馆");

//        Map<String,Object> ss = getJson(params);
        String response = HttpUtil.get(in.getUrl(), getJson(params));
//        AbstractOutParamsPojo out = new AbstractOutParamsPojo();
        OutParamsGeoCoding outParam = new OutParamsGeoCoding();

        outParam = JSON.parseObject(response,outParam.getClass());
        JSONObject json = JSON.parseObject(response);
        System.out.println(outParam.toString());
        return outParam;
    }

    JSONObject getJson(InParamsGeoCoding o){
        Object obj =  JSON.toJSON(o);
        JSONObject json = JSON.parseObject(obj.toString());
        return json;
    }
}
