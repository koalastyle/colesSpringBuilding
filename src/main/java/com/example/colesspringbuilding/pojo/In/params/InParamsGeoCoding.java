package com.example.colesspringbuilding.pojo.In.params;

import lombok.Data;

/**
 * 输入参数类-地理编码
 */
@Data
public class InParamsGeoCoding extends AbstractInParamsPojo{
    protected String address;
    protected String city;
    protected String batch;
    protected String sig;
    protected String output;
    protected String callback;
}
