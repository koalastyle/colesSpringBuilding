package com.example.colesspringbuilding.pojo.Out.params;

import lombok.Data;

/**
 * 输出的抽象类
 */
@Data
public class AbstractOutParamsPojo {
    /**
     返回状态 值为0或1,1：成功；0：失败
     */
    public String status;
    /**
     status为0时，info返回错误原因；否则返回“OK”。TODO 这里可以写一个info状态表
     */
    public String info;



    public boolean isSuccess(){
        return "1".equals(status);
    }
}
