package com.pay.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费
 * com.pay.channel.activemq.MessageListener
 *
 * @author HanKeQi
 * @version V1.1
 * @email h_anke@163.com
 * @create 2017-03-06 15:11
 **/
@Component
public class MessageListener {

    private Logger logger = LoggerFactory.getLogger(MessageListener.class);

    /**使用@JmsListener注解来监听指定的某个队列内的消息,是否有新增,有的话则取出队列内消息
     *进行处理
     **/
    @JmsListener(destination="sample.queue")
    public void removeMessage(String msg){
        logger.debug("activeMQQueue production receive end...:{}",msg); //打印队列内的消息
    }

}
