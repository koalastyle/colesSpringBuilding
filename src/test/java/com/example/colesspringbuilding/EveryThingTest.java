package com.example.colesspringbuilding;

import com.example.colesspringbuilding.pojo.In.InPojo;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author 杜赞豪
 * @Date 2021/12/2 21:23
 **/
public class EveryThingTest {
    @Test

    void suibianTest(){
        InParamsGeoCoding inParams = new InParamsGeoCoding();


        inParams.setKey("123213");
        InPojo<InParamsGeoCoding> in = new InPojo<>(inParams);
//        String url = in.getUrl();
        Object params = in.getParams();
        Class<?> clazz = params.getClass();
        System.out.println("********参数的类型名称为"+clazz);
    }
}
