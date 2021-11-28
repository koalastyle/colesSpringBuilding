package com.example.colesspringbuilding.pojo;

import lombok.Data;

import java.util.List;
@Data
public class OutGeocodesPojo extends OutPojo{
    protected List<GeoCodes> geocodes ;

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
