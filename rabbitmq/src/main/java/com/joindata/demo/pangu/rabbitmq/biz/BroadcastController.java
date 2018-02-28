package com.joindata.demo.pangu.rabbitmq.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.rabbitmq.biz.entity.User;
import com.joindata.inf.common.support.rabbitmq.component.RabbitClient;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/broadcast")
public class BroadcastController
{
    @Autowired
    private RabbitClient client;

    @ApiOperation("发送广播消息，指定 **Fanout** 交换机")
    @PostMapping("/{exchange}/")
    public void sendBroadcast(@PathVariable @ApiParam(value = "**fanout** 交换机", defaultValue = "PANGU.FANOUT") String exchange, @RequestBody User user)
    {
        client.sendBroadcast(user, exchange);
    }

    @ApiOperation("发送广播消息，指定 **Fanout** 交换机和路由键")
    @PostMapping("/{exchange}/{routingKey}/")
    public void sendBroadcast(@PathVariable @ApiParam(value = "**fanout** 交换机", defaultValue = "PANGU.FANOUT") String exchange, @PathVariable @ApiParam(defaultValue = "x") String routingKey, @RequestBody User user)
    {
        client.sendBroadcast(user, exchange, routingKey);
    }
}
