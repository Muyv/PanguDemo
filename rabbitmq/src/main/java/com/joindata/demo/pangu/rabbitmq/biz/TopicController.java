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
@RequestMapping("/topic")
public class TopicController
{
    @Autowired
    private RabbitClient client;

    @ApiOperation("发送主题消息")
    @PostMapping("/{queue}/")
    public void sendTopic(@PathVariable @ApiParam(defaultValue = "CRM.USER") String queue, @RequestBody User user)
    {
        client.sendTopic(queue, user);
    }

    @ApiOperation("发送主题消息，指定 **topic** 交换机")
    @PostMapping("/{queue}/{exchange}/")
    public void sendTopic(@PathVariable @ApiParam(defaultValue = "CRM.USER") String queue, @PathVariable @ApiParam(value = "**topic** 交换机", defaultValue = "PANGU.TOPIC") String exchange, @RequestBody User user)
    {
        client.sendTopic(queue, user, exchange);
    }

    @ApiOperation("发送主题消息，指定 **topic** 交换机和路由键")
    @PostMapping("/{queue}/{exchange}/{routingKey}/")
    public void sendTopic(@PathVariable @ApiParam(defaultValue = "CRM.USER") String queue, @PathVariable @ApiParam(value = "**topic** 交换机", defaultValue = "PANGU.TOPIC") String exchange, @PathVariable @ApiParam(defaultValue = "x") String routingKey, @RequestBody User user)
    {
        client.sendTopic(queue, user, exchange, routingKey);
    }
}
