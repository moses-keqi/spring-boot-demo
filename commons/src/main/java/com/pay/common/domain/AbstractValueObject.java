package com.pay.common.domain;

import com.pay.common.helper.JacksonHelper;
import com.pay.common.protocol.api.ApiCallParamSupport;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * 值对象 无ID
 */
public abstract class AbstractValueObject implements Serializable, ApiCallParamSupport {

    private static final long serialVersionUID = -2173582091127969079L;

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return JacksonHelper.parseToJson(this);
    }

    @Override
    public String toJsonStr() {
        return JacksonHelper.parseToJson(this);
    }

}
