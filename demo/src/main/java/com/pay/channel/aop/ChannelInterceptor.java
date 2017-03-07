package com.pay.channel.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import com.pay.common.helper.LoggerHelper;

@Component
public class ChannelInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String invokeName = LoggerHelper.getInvokeName(invocation);
        long startTime = LoggerHelper.beginInvoke(invokeName, ChannelInterceptor.class);
        Object result = null;
        try {
            // 执行方法
            result = invocation.proceed();
        } catch (Throwable e) {
            LoggerHelper.endInvokeWithErrors(invokeName, ChannelInterceptor.class, startTime);
            throw e;
        }
        LoggerHelper.endInvoke(invokeName, ChannelInterceptor.class, startTime);
        return result;

    }
}
