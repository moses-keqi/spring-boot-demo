package com.pay.channel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pay.common.domain.po.Recurring;
import com.pay.common.service.RecurringService;

/**
 * Created by kaifa4 on 2017/1/17.
 */
@Controller
public class RecurringController {

    @Autowired
    private RecurringService recurringService;


    //测试dome
    @RequestMapping(value = "getRecurring", method = RequestMethod.GET)
    @ResponseBody
    public List<Recurring> getRecurring() throws Exception{
        return  recurringService.getSelectRecurring();
    }

}
