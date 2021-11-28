package com.example.colesspringbuilding.pojo.In;

import com.example.colesspringbuilding.pojo.In.params.AbstractInParamsPojo;
import lombok.Data;

/**
 * 存放url之类的非输入字符的公有类
 */
@Data
public class InHeadPojo {
    String url;

    AbstractInParamsPojo params;
}
