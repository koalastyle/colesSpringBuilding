package com.example.colesspringbuilding.pojo.Out.params;

import lombok.Data;

import java.util.List;

/**
 * 输出类
 * 地理编码：输入地址进行编码
 * 2021.11.28
 *
 */
@Data
public class OutParamsGeoCoding extends AbstractOutParamsPojo {
    public List<OutParamsGeoCoding.GeoCodes> geocodes ;

    @Data
    public class GeoCodes {
        protected String formatted_address;
        protected String country;
        protected String province;
        protected String city;
        protected String citycode;
        protected String district;
        protected String street;
        protected String number;
        protected String adcode;
        protected String location;
        protected String level;
    }
}
