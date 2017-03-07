package com.pay.channel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pay.common.domain.po.ChannelRoute;
import com.pay.common.service.ChannelRouteService;

/**
 * Created by kaifa4 on 2017/1/17.
 */
@Controller
public class ChannelController {

    @Autowired
    private ChannelRouteService channelRouteService;


    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    
    @RequestMapping(value = "index", method = RequestMethod.GET)
    @ResponseBody
    public ChannelRoute index() throws Exception{
        ChannelRoute channelRoute = new ChannelRoute();
        channelRoute.setId(1L);
        channelRouteService.create(channelRoute);
        return  channelRoute;
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    @ResponseBody
    public ChannelRoute hedleUpdate() throws Exception{
        ChannelRoute channelRoute = new ChannelRoute();
        channelRoute.setId(1L);
        channelRouteService.update(channelRoute);
        return  channelRoute;
    }

    @RequestMapping(value = "getChannelRoute", method = RequestMethod.GET)
    @ResponseBody
    public List<ChannelRoute> getChannelRoute() throws Exception{
        return  channelRouteService.getChannelRoute();
    }
}
