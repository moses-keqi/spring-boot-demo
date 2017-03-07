package com.pay.common.domain;



import com.pay.common.helper.JacksonHelper;
import com.pay.common.protocol.api.ApiCallParamSupport;

import java.io.Serializable;

public abstract class AbstractDto implements Serializable, ApiCallParamSupport {

    /**
     * @since JDK 1.8
     */
    private static final long serialVersionUID = -7429526687807339961L;

    @Override
    public String toJsonStr() {
        return JacksonHelper.parseToJson(this);
    }
}
