package testDemo;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.colesspringbuilding.constant.DConstant;
import com.example.colesspringbuilding.pojo.In.InHeadPojo;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.OutGeocodesPojo;

import java.util.HashMap;
import java.util.Map;



public class demo1 {
    private static final String URL = "https://restapi.amap.com/v3/geocode/geo";
    public static void main(String[] args) {
        InParamsGeoCoding params = new InParamsGeoCoding();
        InHeadPojo in = new InHeadPojo();
        in.setUrl("https://restapi.amap.com/v3/geocode/geo");
        params.setKey(DConstant.GEO_KEY);
        params.setAddress("北京市建国门大街3号");

        Map<String,Object> inParams = new HashMap<>();
        inParams.put("address","成都市电子科技大学");
        inParams.put("key", DConstant.GEO_KEY);
        String response = HttpUtil.get(in.getUrl(),inParams);//TODO 工具类无法对obj格式的进行get
        OutGeocodesPojo out = new OutGeocodesPojo();
        out = JSON.parseObject(response,out.getClass());
        JSONObject json = JSON.parseObject(response);
        System.out.println(json.toString(SerializerFeature.PrettyFormat));
    }
}
