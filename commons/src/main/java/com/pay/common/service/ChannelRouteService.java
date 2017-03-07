package com.pay.common.service;

import java.util.List;

import com.pay.common.domain.po.ChannelRoute;

/**
 * Created by HanKeQi on 2017/1/17.
 */
public interface ChannelRouteService{

    public void create(ChannelRoute channelRoute) throws Exception;

    public ChannelRoute update(ChannelRoute channelRoute) throws Exception;

    public List<ChannelRoute> getChannelRoute() throws Exception;
    
}
