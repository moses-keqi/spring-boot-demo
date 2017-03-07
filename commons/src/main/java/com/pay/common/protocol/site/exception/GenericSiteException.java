package com.pay.common.protocol.site.exception;

/**
 * 默认/一般/泛指的表示层异常
 */
public class GenericSiteException extends AbstractSiteException {

    public GenericSiteException() {
        super();
    }

    public GenericSiteException(String msg) {
        super(msg);
    }
    // nothing
}
