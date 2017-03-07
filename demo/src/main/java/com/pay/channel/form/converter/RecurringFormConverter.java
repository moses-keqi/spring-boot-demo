package com.pay.channel.form.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.pay.channel.form.RecurringForm;
import com.pay.common.domain.po.Recurring;
import com.pay.common.service.RecurringService;

@Component
public class RecurringFormConverter implements AbstractFormConverter<Recurring, RecurringForm>{

	//此类建议使用biz 因为service注册了服务端
	@Autowired
	private RecurringService recurringService;
	
	@Override
	public RecurringForm fromEntity(Recurring e) throws Exception {
		RecurringForm f = new RecurringForm();
		f.setAmount(e.getAmount());
		
		return f;
	}

	//测试
	@Override
	public Recurring toEntity(RecurringForm f) throws Exception {
		//getById
		List<Recurring> selectRecurring = recurringService.getSelectRecurring();
		if (!CollectionUtils.isEmpty(selectRecurring)) {
			return selectRecurring.get(0);
		}else{
			Recurring e = new Recurring();
			return e;
		}
	}

}
