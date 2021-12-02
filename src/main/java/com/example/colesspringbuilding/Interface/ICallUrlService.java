package com.example.colesspringbuilding.Interface;

import com.example.colesspringbuilding.pojo.In.InPojo;
import com.example.colesspringbuilding.pojo.In.params.AbstractInParamsPojo;
import com.example.colesspringbuilding.pojo.In.params.InParamsGeoCoding;
import com.example.colesspringbuilding.pojo.Out.params.AbstractOutParamsPojo;
import com.example.colesspringbuilding.pojo.Out.params.OutParamsGeoCoding;

/**
 * @Author 杜赞豪
 */
public interface ICallUrlService {
    /**
     * @param
     * @return
     */
    AbstractOutParamsPojo callUrl(InPojo<? extends AbstractInParamsPojo> in);

    /**
     * @param inParams
     * @return
     */
    OutParamsGeoCoding callUrlGeoCoding(InParamsGeoCoding inParams);
}
