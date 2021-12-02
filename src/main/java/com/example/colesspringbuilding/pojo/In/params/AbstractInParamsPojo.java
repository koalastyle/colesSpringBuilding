package com.example.colesspringbuilding.pojo.In.params;

import com.example.colesspringbuilding.pojo.Out.params.AbstractOutParamsPojo;
import lombok.Data;

/**
 * 输入类的父类
 */
@Data
public abstract class AbstractInParamsPojo {
    private String key;

    public abstract <T extends AbstractOutParamsPojo> Class<T> getOutClass();


    public abstract String getUrl();
}
