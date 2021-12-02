package com.example.colesspringbuilding.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.colesspringbuilding.Interface.ICallUrlService;
import com.example.colesspringbuilding.constant.DConstant;
import com.example.colesspringbuilding.pojo.In.InPojo;
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
    public <T extends AbstractOutParamsPojo> T callUrl(InPojo in) {
        //TODO 也可以根据输入类类型 取值  map或者竖表
        String url = in.getUrl();

        Class<?> clazz = in.getParams().getClass();
        //TODO 根据输入类来判断输出类是哪个，即T(AbstractOutParamsPojo的子类) map或者竖表
        Class outClass = getOutType(clazz.toString());
        String response = HttpUtil.get(in.getUrl(), getJson(in.getParams()));
        //TODO 将取得的T的类名放入
        T out = JSON.parseObject(response,(Class<T>)outClass);
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
     * @param <T>
     * @return
     */
    <T extends AbstractInParamsPojo> JSONObject  getJson(T o){
        Object obj =  JSON.toJSON(o);
        JSONObject json = JSON.parseObject(obj.toString());
        return json;
    }

    /**
     * 根据输入类获取输出类名
     * @param clazz
     * @return
     */
    <E extends AbstractOutParamsPojo>  Class<E> getOutType( String clazz){
        return null;
    }
}
