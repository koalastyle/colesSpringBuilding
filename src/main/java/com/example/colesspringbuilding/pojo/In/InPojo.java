package com.example.colesspringbuilding.pojo.In;

import com.example.colesspringbuilding.pojo.In.params.AbstractInParamsPojo;
import lombok.Data;

/**
 * 整合两个类的第三个类
 */
@Data
public class InPojo {
    public String url;

    public AbstractInParamsPojo params;
}
