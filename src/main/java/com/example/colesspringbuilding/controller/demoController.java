package com.example.colesspringbuilding.controller;

import cn.hutool.core.util.StrUtil;
import com.example.colesspringbuilding.Interface.ICallUrlService;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.Out.params.OutParamsGeoCoding;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class demoController {
    @Value("${app.secret-key:}")
    private String secretKey;

    private static final String URL = "https://restapi.amap.com/v3/geocode/geo";

    @Resource
    private ICallUrlService callUrlService;

    @RequestMapping("/hello")
    public Object hello() throws Exception {
        if (StrUtil.isBlank(secretKey)) {
            throw new Exception("未配置高德地图开发平台密钥");
        }

        InParamsGeoCoding params = new InParamsGeoCoding();
        params.setKey(secretKey);
        params.setAddress("四川省成都市博物馆");
        if(params.getAddress().contains("|")){
            params.setBatch("true");
        }
        OutParamsGeoCoding out = callUrlService.callUrl(params);

        return out.toString();
    }


}
