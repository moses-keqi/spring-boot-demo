package com.pay.channel.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.StatementType;

import com.pay.channel.dao.provider.ChannelRouteProvider;
import com.pay.common.domain.po.ChannelRoute;

/**
 * Created by HanKeQi on 2017/1/17.
 */
//@Mapper
public interface ChannelRouteMapper {

    @InsertProvider(type = ChannelRouteProvider.class, method = "insert")
    @SelectKey(before = false, keyProperty = "id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "call identity()")
    void insert(ChannelRoute channelRoute);

    @UpdateProvider(type = ChannelRouteProvider.class, method = "update")
    void update(ChannelRoute channelRoute) throws Exception;

    @SelectProvider(type = ChannelRouteProvider.class, method = "getSelectChannelRoute")
    List<ChannelRoute> getSelectChannelRoute() throws Exception;

}
