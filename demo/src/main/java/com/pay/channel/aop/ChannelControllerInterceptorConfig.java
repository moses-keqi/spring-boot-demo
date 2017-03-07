package com.pay.channel.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class ChannelControllerInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ChannelControllerInterceptor channelControllerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 不拦截spring mvc 默认的出错页面 和首页-- /error,/
        //registry.addInterceptor(auditLogControllerInterceptor).excludePathPatterns("/error", "/").addPathPatterns("/**");
        registry.addInterceptor(channelControllerInterceptor).excludePathPatterns("/error").addPathPatterns("/**");
    }

}
