package com.example.colesspringbuilding.pojo.In.params;

import com.example.colesspringbuilding.pojo.Out.params.OutParamsGeoCoding;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 输入参数类-地理编码
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InParamsGeoCoding extends AbstractInParamsPojo {
    protected String address;
    protected String city;
    protected String batch;
    protected String sig;
    protected String output;
    protected String callback;

    @Override
    public Class<OutParamsGeoCoding> getOutClass() {
        return OutParamsGeoCoding.class;
    }
}
