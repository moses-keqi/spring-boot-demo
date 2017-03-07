package com.pay.channel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Service;
import com.pay.channel.dao.mapper.RecurringMapper;
import com.pay.common.domain.po.Recurring;
import com.pay.common.service.RecurringService;

/**
 * Created by HanKeQi on 2017/1/17.
 */
@Service(version = "1.0.0")
//@Service
public class RecurringServiceImpl implements RecurringService{

    @Autowired
    private RecurringMapper recurringMapper;

    public List<Recurring> getSelectRecurring() throws Exception{
        return recurringMapper.getSelectRecurring();
    }
}
