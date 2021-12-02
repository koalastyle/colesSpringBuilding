package com.example.colesspringbuilding.pojo.In;

import com.example.colesspringbuilding.pojo.In.params.AbstractInParamsPojo;
import lombok.Data;

/**
 * 整合两个类的第三个类
 */
@Data
public class InPojo<T extends AbstractInParamsPojo> {
    public String url;

    public T params;

    public InPojo(T in){     // 通过构造方法设置属性内容
        this.setParams(in) ;
    }
    public InPojo(){     // 通过构造方法设置属性内容

    }
}
