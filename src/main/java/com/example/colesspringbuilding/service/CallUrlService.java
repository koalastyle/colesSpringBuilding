package com.example.colesspringbuilding.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.Interface.ICallUrlService;
import com.example.colesspringbuilding.constant.DConstant;
import com.example.colesspringbuilding.pojo.In.params.AbstractInParamsPojo;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.Out.params.AbstractOutParamsPojo;
import com.example.colesspringbuilding.pojo.Out.params.OutParamsGeoCoding;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CallUrlService implements ICallUrlService {
    @Value("${app.secret-key:}")
    private String secretKey;

    @Override
    public <T extends AbstractOutParamsPojo,E extends AbstractInParamsPojo> T callUrl(E in) {
        //获取url
        String url = in.getUrl();
        //获取对应的输出类
        Class<T> outClass = in.getOutClass();
        //通过url进行调用
        String response = HttpUtil.get(url, getJson(in));
        //将取得的T的类名放入
        T out = JSON.parseObject(response,outClass);
        return out;
    }

    @Override
    public OutParamsGeoCoding callUrlGeoCoding(InParamsGeoCoding inParams) {
        //设置key
        inParams.setKey(secretKey);

        if(inParams.getAddress().contains("|")){
            inParams.setBatch("true");
        }

        String response = HttpUtil.get(DConstant.URL_GEO_CODING, getJson(inParams));
        OutParamsGeoCoding outParam = new OutParamsGeoCoding();

        outParam = JSON.parseObject(response,outParam.getClass());

        return outParam;
    }

    /**
     * 获取对象的json格式
     * @param o
     * @param <E>
     * @return
     */
    <E extends AbstractInParamsPojo> JSONObject  getJson(E o){
        Object obj =  JSON.toJSON(o);
        JSONObject json = JSON.parseObject(obj.toString());
        return json;
    }



}
