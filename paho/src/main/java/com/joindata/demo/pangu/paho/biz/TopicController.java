package com.joindata.demo.pangu.paho.biz;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.paho.biz.entity.JsonOrder;
import com.joindata.demo.pangu.paho.biz.entity.NotifyWrapper;
import com.joindata.demo.pangu.paho.biz.entity.Order;
import com.joindata.inf.common.support.paho.component.PahoClient;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/topic")
public class TopicController
{
    @Autowired
    private PahoClient client;

    @ApiOperation("发送消息，用 Java 序列化")
    @PostMapping("/PRINTER.ORDER/")
    public void sendJava(@RequestBody Order[] order) throws MqttPersistenceException, MqttException
    {
        client.send("PRINTER.ORDER", order);
    }

    @ApiOperation("发送消息，用 JSON 序列化")
    @PostMapping("/PRINTER.JSON_ORDER/")
    public void sendJson(@RequestBody JsonOrder[] order) throws MqttPersistenceException, MqttException
    {
        client.sendJson("PRINTER.JSON_ORDER", order);
    }

    @ApiOperation("发送消息，直接发字符串")
    @PostMapping(path = "/PRINTER.NOTIFY/")
    public void send(@RequestBody NotifyWrapper notify) throws MqttPersistenceException, MqttException
    {
        client.send("PRINTER.NOTIFY", notify.getMessage());
    }
}
