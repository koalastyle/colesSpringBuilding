package com.example.colesspringbuilding.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.colesspringbuilding.constant.DConstant;
import com.example.colesspringbuilding.pojo.OutGeocodesPojo;
import com.example.colesspringbuilding.pojo.OutPojo;
import com.example.colesspringbuilding.pojo.geoCodes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class demoController {

    private static final String URL = "https://restapi.amap.com/v3/geocode/geo";

    @RequestMapping("/hello")
    public Object hello(){

        Map<String,Object> inParams = new HashMap<>();
        inParams.put("address","成都市电子科技大学|四川大学");
        inParams.put("key", DConstant.GEO_KEY);
        inParams.put("batch", "true");
        String response = HttpUtil.get(URL,inParams);
        OutGeocodesPojo out = new OutGeocodesPojo();
        out = JSON.parseObject(response,OutGeocodesPojo.class);
        JSONObject json = JSON.parseObject(response);
        System.out.println(json.toString(SerializerFeature.PrettyFormat));
        return out;
    }
}
