package com.pay.common.protocol.api.exception;

/**
 * 所有业务相关异常的抽象父类 将自身类名作为错误码返回码
 */
public abstract class AbstractBizException extends RuntimeException {

    public AbstractBizException() {
    }

    public AbstractBizException(String msg) {
        super(msg);
    }

    public AbstractBizException(Throwable e) {
        super(e);
    }

    public AbstractBizException(String msg, Throwable e) {
        super(msg, e);
    }

    public String getErrorCode() {
        return getClass().getName();
    }

}
