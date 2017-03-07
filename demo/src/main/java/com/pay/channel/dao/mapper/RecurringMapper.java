package com.pay.channel.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.pay.channel.dao.provider.RecurringProvider;
import com.pay.common.domain.po.Recurring;

/**
 * Created by kaifa4 on 2017/1/17.
 */
//@Mapper
public interface RecurringMapper {

    @SelectProvider(type = RecurringProvider.class, method = "getSelectRecurring")
    List<Recurring> getSelectRecurring() throws Exception;

}
