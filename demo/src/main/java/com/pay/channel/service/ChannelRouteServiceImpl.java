package com.pay.channel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Service;
import com.pay.channel.dao.mapper.ChannelRouteMapper;
import com.pay.common.domain.po.ChannelRoute;
import com.pay.common.service.ChannelRouteService;

/**
 * Created by HanKeQi on 2017/1/17.
 * 此应用用于service和dubbo
 */
@Service(version = "1.0.0")
//@Service
public class ChannelRouteServiceImpl implements ChannelRouteService{

    @Autowired
    private ChannelRouteMapper channelRouteMapper;

    public void create(ChannelRoute channelRoute){
        channelRouteMapper.insert(channelRoute);
    }

    public ChannelRoute update(ChannelRoute channelRoute) throws Exception{
        channelRouteMapper.update(channelRoute);
        return channelRoute;
    }

    public List<ChannelRoute> getChannelRoute() throws Exception{
        return channelRouteMapper.getSelectChannelRoute();
    }
}
