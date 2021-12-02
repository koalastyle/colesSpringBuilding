package com.example.colesspringbuilding;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.constant.DConstant;
import com.example.colesspringbuilding.pojo.In.InPojo;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.Out.params.OutParamsGeoCoding;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;

@SpringBootTest
@ActiveProfiles("dev")
class ColesSpringBuildingApplicationTests {
    @Value("${app.secret-key:}")
    private String secretKey;

    @Test
    void contextLoads() {
       /* OutGeocodesPojo outGeocodesPojo = new OutGeocodesPojo();
        outGeocodesPojo.setInfo("success");
        Object o = JSON.toJSON(outGeocodesPojo);
        JSONObject jsonObject = JSON.parseObject(o.toString());
        System.out.println(jsonObject);

        */

        InParamsGeoCoding params = new InParamsGeoCoding();
        InPojo in = new InPojo();
        in.setUrl("https://restapi.amap.com/v3/geocode/geo");

        params.setKey(secretKey);
        System.out.println("secretKey="+secretKey);
        params.setAddress("四川省成都市博物馆|资阳市雁江区摩根时代");

        if(params.getAddress().contains("|")){
            params.setBatch("true");
        }

//        Map<String,Object> ss = getJson(params);
        String response = HttpUtil.get(in.getUrl(), getJson(params));
//        AbstractOutParamsPojo out = new AbstractOutParamsPojo();
        OutParamsGeoCoding outParam = new OutParamsGeoCoding();

        outParam = JSON.parseObject(response,outParam.getClass());
        JSONObject json = JSON.parseObject(response);
        System.out.println(outParam.toString());
    }
    @Test
    void staticMapTest(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("key",secretKey);
        map.put("zoom","5");
//        map.put("location","104.644790,30.117735");
//        map.put("size","large");
//        map.put("markers","mid,0xFF0000,A:116.37359,39.92437;116.47359,39.92437");
        map.put("markers","-1");
        String response = HttpUtil.get(DConstant.URL_STATIC_MAP, map);
        JSONObject json = JSON.parseObject(response);
        System.out.println(json.toString());
    }


     JSONObject getJson(InParamsGeoCoding o){
        Object obj =  JSON.toJSON(o);
        JSONObject json = JSON.parseObject(obj.toString());
        return json;
    }




}
