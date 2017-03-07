package com.pay.common.service;

import java.util.List;

import com.pay.common.domain.po.Recurring;

/**
 * Created by HanKeQi on 2017/1/17.
 */
public interface RecurringService{

    public List<Recurring> getSelectRecurring() throws Exception;
    
}
