//package com.pay.channel;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.pay.ChannelApplication;
//
////测试使用，如果想调用此方法 请继承此类
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ChannelApplication.class)
//@ComponentScan("com.pay")
//public class BaseTest {
//
//	static{
//        System.setProperty("PAY_ENV", "dev");
//    }
//    
//    public Logger LOGGER = LoggerFactory.getLogger(getClass());
//    
//    @Test
//    public void test(){
//        LOGGER.debug("start unit test");
//    }
//	
//}
