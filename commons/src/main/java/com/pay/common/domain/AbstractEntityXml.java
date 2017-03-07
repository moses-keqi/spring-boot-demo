//package com.pay.common.domain;
//
//import java.io.Serializable;
//
//import com.pay.common.helper.JacksonHelper;
//import com.pay.common.protocol.api.CallParamSupportXml;
//
///**
// * Created by HanKeQi on 2017/1/18.
// * 此类是为了将对象转成XML
// */
//public abstract class AbstractEntityXml implements Serializable, CallParamSupportXml{
//
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 8472223711121970606L;
//
//	@Override
//    public String toString() {
//        return JacksonHelper.parseToXml(this);
//    }
//
//    @Override
//    public String toXmlStr() {
//        return JacksonHelper.parseToXml(this);
//    }
//
//
//}
