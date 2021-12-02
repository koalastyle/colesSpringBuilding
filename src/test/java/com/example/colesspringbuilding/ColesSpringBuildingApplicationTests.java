package com.example.colesspringbuilding;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.Interface.ICallUrlService;
import com.example.colesspringbuilding.constant.DConstant;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.Out.params.OutParamsGeoCoding;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

@SpringBootTest
@ActiveProfiles("dev")
class ColesSpringBuildingApplicationTests {
    @Value("${app.secret-key:}")
    private String secretKey;
    @Resource
    private ICallUrlService callUrlService;

    @Test
    void TestCallUrl() {
       /* OutGeocodesPojo outGeocodesPojo = new OutGeocodesPojo();
        outGeocodesPojo.setInfo("success");
        Object o = JSON.toJSON(outGeocodesPojo);
        JSONObject jsonObject = JSON.parseObject(o.toString());
        System.out.println(jsonObject);

        */

        InParamsGeoCoding params = new InParamsGeoCoding();


        params.setKey(secretKey);
        System.out.println("secretKey=" + secretKey);
        params.setAddress("四川省成都市博物馆|资阳市雁江区摩根时代");

        if (params.getAddress().contains("|")) {
            params.setBatch("true");
        }


        OutParamsGeoCoding outParam = callUrlService.callUrl(params);
        System.out.println(outParam.toString());
    }

    @Test
    void staticMapTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", secretKey);
        map.put("zoom", "5");
//        map.put("location","104.644790,30.117735");
//        map.put("size","large");
//        map.put("markers","mid,0xFF0000,A:116.37359,39.92437;116.47359,39.92437");
        map.put("markers", "-1");
        String response = HttpUtil.get(DConstant.URL_STATIC_MAP, map);
        JSONObject json = JSON.parseObject(response);
        System.out.println(json.toString());
    }


    JSONObject getJson(InParamsGeoCoding o) {
        Object obj = JSON.toJSON(o);
        JSONObject json = JSON.parseObject(obj.toString());
        return json;
    }

    @Test
    void a() throws IOException {
        String url = "https://restapi.amap.com/v3/staticmap?zoom=15&size=500*500&paths=10,0x0000ff,1,,:116.31604,39.96491;116.320816,39.966606;116.321785,39.966827;116.32361,39.966957&key=" + secretKey;
        HttpResponse execute = HttpUtil.createGet(url).execute();
        byte[] bytes = execute.bodyBytes();
        FileOutputStream fos = new FileOutputStream("data.png");
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        channel.write(buffer);
        channel.close();
    }


}
