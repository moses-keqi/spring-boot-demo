package com.pay.channel.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by kaifa4 on 2017/1/17.
 */
@Component
public class ChannelControllerInterceptor extends HandlerInterceptorAdapter{

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelControllerInterceptor.class);

    private static final ThreadLocal<Long> localTime = new ThreadLocal<Long>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        localTime.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView)
            throws Exception {
        Method method = ((HandlerMethod) obj).getMethod();
        Long now = System.currentTimeMillis();
        Integer costTime = (int) (now - localTime.get());
        if (costTime > 3000) {
            LOGGER.warn("url request {},method is {}, cost time: {}. It's too slowly", request.getRequestURI(), method.getName(), costTime);
        } else {
            LOGGER.debug("url request {},method is {}, cost time: {}", request.getRequestURI(), method.getName(), costTime);
        }

    }
}
