package com.pay.common.domain;


import com.pay.common.helper.JacksonHelper;
import com.pay.common.protocol.api.ApiCallParamSupport;

import java.io.Serializable;

/**
 * Created by HanKeQi on 2017/1/18.
 * 此类是为了将对象转成json
 */
public abstract class AbstractEntity implements Serializable, ApiCallParamSupport {

    private static final long serialVersionUID = -2003582091127969079L;

    @Override
    public String toString() {
        return JacksonHelper.parseToJson(this);
    }

    @Override
    public String toJsonStr() {
        return JacksonHelper.parseToJson(this);
    }

}
