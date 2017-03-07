package com.pay.channel.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.pay.common.domain.po.Recurring;
import com.pay.common.mybatis.CrudProvider;

/**
 * 相关Api
 * org.apache.ibatis.jdbc.AbstractSQL<T>
 * 
 * Created by HanKeQi on 2017/1/17.
 */
public class RecurringProvider extends CrudProvider<Recurring>{

    public String getSelectRecurring(){
        return new SQL(){{
            SELECT("*");
            FROM(RecurringProvider.this.tableName);
            WHERE("rownum<=10");
        }}.toString();
    }


}
