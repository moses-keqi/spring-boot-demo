package com.pay.channel.dao.provider;


import org.apache.ibatis.jdbc.SQL;

import com.pay.common.domain.po.ChannelRoute;
import com.pay.common.mybatis.CrudProvider;

/**
 * 相关Api
 * org.apache.ibatis.jdbc.AbstractSQL<T>
 * Created by HanKeQi on 2017/1/17.
 */
public class ChannelRouteProvider extends CrudProvider<ChannelRoute>{

    //测试
    public String getSelectChannelRoute(){
        return new SQL(){{
            SELECT("*");
            FROM(ChannelRouteProvider.this.tableName);
        }}.toString();
    }


}
