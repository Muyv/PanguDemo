package com.joindata.demo.pangu.rabbitmq.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.rabbitmq.biz.entity.Contact;
import com.joindata.inf.common.support.rabbitmq.component.RabbitClient;
import com.joindata.inf.common.support.rabbitmq.enums.RabbitFeature;

/**
 * 这个例子演示如何用 JSON 序列化或直接用字符串发送消息
 * 
 * @author <a href="mailto:songxiang@joindata.com">宋翔</a>
 * @date Apr 14, 2017 4:17:22 PM
 */
@RestController
@RequestMapping("/example/")
public class OtherExampleController
{
    @Autowired
    private RabbitClient client;

    @PostMapping("/JsonSerialization")
    public void jsonSerialization(@RequestBody Contact contact)
    {
        // RabbitFeature.JsonSerialization 表示将数据通过 JSON 序列化后发送
        client.sendDirect("CRM.CONTACT", contact, "PANGU.DIRECT", "contact", RabbitFeature.JsonSerialization);
    }

    @PostMapping("/SendText")
    public void sendText()
    {
        // 可直接发送字符串
        client.sendBroadcast("白百合也出轨啦...", "PANGU.FANOUT", "frontpage");
    }
}
