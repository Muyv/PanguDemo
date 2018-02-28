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
@RequestMapping("/direct")
public class DirectController
{
    @Autowired
    private RabbitClient client;

    @ApiOperation("发送直达消息")
    @PostMapping("/{queue}/")
    public void sendDirect(@PathVariable @ApiParam(defaultValue = "CRM.USER") String queue, @RequestBody User user)
    {
        client.sendDirect(queue, user);
    }

    @ApiOperation("发送直达消息，指定 **Direct** 交换机")
    @PostMapping("/{queue}/{exchange}/")
    public void sendDirect(@PathVariable @ApiParam(defaultValue = "CRM.USER") String queue, @PathVariable @ApiParam(value = "**direct** 交换机", defaultValue = "PANGU.DIRECT") String exchange, @RequestBody User user)
    {
        client.sendDirect(queue, user, exchange);
    }

    @ApiOperation("发送直达消息，指定 **Direct** 交换机和路由键")
    @PostMapping("/{queue}/{exchange}/{routingKey}/")
    public void sendDirect(@PathVariable @ApiParam(defaultValue = "CRM.USER") String queue, @PathVariable @ApiParam(value = "**direct** 交换机", defaultValue = "PANGU.DIRECT") String exchange, @PathVariable @ApiParam(defaultValue = "x") String routingKey, @RequestBody User user)
    {
        client.sendDirect(queue, user, exchange, routingKey);
    }
}
