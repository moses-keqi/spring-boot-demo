package com.pay.common.protocol.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@FunctionalInterface // 表示此接口是函数式接口，即仅仅只能有一个抽象方法。为了方便lambda表达式用之
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ApiCallParamSupport {

    String toJsonStr();

}
