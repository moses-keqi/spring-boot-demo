package com.pay.channel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by HanKeQi on 2017/1/17.
 * Spring-boot 入口
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class ChannelApplication extends SpringBootServletInitializer{

    public static final String ID = "CHANNEL";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ChannelApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ChannelApplication.class, args);
    }

}
