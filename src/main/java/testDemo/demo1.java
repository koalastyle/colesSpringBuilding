package testDemo;

import cn.hutool.http.HttpUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import com.example.colesspringbuilding.constant.DConstant;
import com.example.colesspringbuilding.pojo.OutPojo;
import com.example.colesspringbuilding.pojo.geoCodes;


import java.util.HashMap;
import java.util.Map;

public class demo1 {
    private static final String URL = "https://restapi.amap.com/v3/geocode/geo";
    public static void main(String[] args) {
        Map<String,Object> inParams = new HashMap<>();
        inParams.put("address","成都市电子科技大学");
        inParams.put("key", DConstant.GEO_KEY);
        String response = HttpUtil.get(URL,inParams);
        OutPojo<geoCodes> out = new OutPojo();
        out = JSON.parseObject(response,OutPojo.class);
        JSONObject json = JSON.parseObject(response);
        System.out.println(json.toString(SerializerFeature.PrettyFormat));
    }
}
