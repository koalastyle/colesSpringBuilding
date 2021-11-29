package com.example.colesspringbuilding;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.pojo.OutGeocodesPojo;
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
        OutGeocodesPojo outGeocodesPojo = new OutGeocodesPojo();
        outGeocodesPojo.setInfo("success");
        Object o = JSON.toJSON(outGeocodesPojo);
        JSONObject jsonObject = JSON.parseObject(o.toString());
        System.out.println(jsonObject);
    }

}
