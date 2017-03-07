package com.pay.channel.form;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 校验不符合相应注解的字段，减少对数据的访问
 * @author HanKeQi
 *
 */
public abstract class AbstractForm {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
