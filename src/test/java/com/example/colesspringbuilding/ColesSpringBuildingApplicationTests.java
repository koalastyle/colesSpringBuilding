package com.example.colesspringbuilding;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.pojo.In.InPojo;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.Out.params.OutParamsGeoCoding;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
        params.setAddress("四川省成都市博物馆");


//        Map<String,Object> ss = getJson(params);
        String response = HttpUtil.get(in.getUrl(), getJson(params));
//        AbstractOutParamsPojo out = new AbstractOutParamsPojo();
        OutParamsGeoCoding outParam = new OutParamsGeoCoding();

        outParam = JSON.parseObject(response,outParam.getClass());
        JSONObject json = JSON.parseObject(response);
        System.out.println(outParam.toString());
    }

     JSONObject getJson(InParamsGeoCoding o){
        Object obj =  JSON.toJSON(o);
        JSONObject json = JSON.parseObject(obj.toString());
        return json;
    }


}
