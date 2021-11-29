package testDemo;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.pojo.In.InHeadPojo;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.OutGeocodesPojo;



public class demo1 {

    public static void main(String[] args) {
        InParamsGeoCoding params = new InParamsGeoCoding();
        InHeadPojo in = new InHeadPojo();
        in.setUrl("https://restapi.amap.com/v3/geocode/geo");
//        params.setKey(DConstant.GEO_KEY);
        params.setAddress("四川省成都市博物馆");


//        Map<String,Object> ss = getJson(params);
        String response = HttpUtil.get(in.getUrl(), getJson(params));
        OutGeocodesPojo out = new OutGeocodesPojo();
        out = JSON.parseObject(response,out.getClass());
        JSONObject json = JSON.parseObject(response);
        System.out.println(out.toString());
    }


   static JSONObject getJson(InParamsGeoCoding o){
        Object obj =  JSON.toJSON(o);
        JSONObject json = JSON.parseObject(obj.toString());
        return json;
    }
}
