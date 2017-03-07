package com.pay.dubbo;

import com.pay.common.service.RecurringService;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author HanKeQi
 * @since 服务消费者
 */
@Component
public class TestService {

	//等价于dubbo:reference TODO 此注解有待改进
	@Reference(version = "1.0.0")
	public RecurringService recurringService;
}
