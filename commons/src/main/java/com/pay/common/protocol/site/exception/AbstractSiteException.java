package com.pay.common.protocol.site.exception;

/**
 * 网站接口异常 例如: 用户输入验证失败
 */
public abstract class AbstractSiteException extends RuntimeException {

    public AbstractSiteException() {
    }

    public AbstractSiteException(String msg) {
        super(msg);
    }

    public AbstractSiteException(Throwable e) {
        super(e);
    }

    public AbstractSiteException(String msg, Throwable e) {
        super(msg, e);
    }

    public String getErrorCode() {
        return getClass().getName();
    }

}
