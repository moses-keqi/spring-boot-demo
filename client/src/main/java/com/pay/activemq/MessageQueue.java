package com.pay.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 * MessageQueue
 * com.pay.channel.activemq.MessageQueue
 *
 * @author HanKeQi
 * @version V1.1
 * @email h_anke@163.com
 * @create 2017-03-06 15:11
 **/
@Configuration
@EnableJms
public class MessageQueue {

    //返回一个名为my-message的队列,并且注册为bean
    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue("sample.queue");
    }

}
