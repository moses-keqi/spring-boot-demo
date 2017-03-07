package com.pay.channel.activemq;

import org.apache.activemq.broker.region.Destination;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * MessageProduction
 * com.pay.channel.config.MessageProduction
 *
 * @author HanKeQi
 * @version V1.1
 * @email h_anke@163.com
 * @create 2017-03-06 15:05
 **/
@Component
@EnableScheduling
public class MessageProduction {

    private static final Logger logger = LoggerFactory.getLogger(MessageProduction.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;//使用JmsMessagingTemplate将消息放入队列

    @Autowired
    private ActiveMQQueue activeMQQueue;

    @Scheduled(fixedDelay = 3000)//每3s执行1次,将消息放入队列内
    public void send() {
        //for(int i=0; i< 100000; i++){
            logger.debug("activeMQQueue production send start...");
            jmsMessagingTemplate.convertAndSend(activeMQQueue, String.format("activeMQQueue production start... "));
        //}
    }

}
