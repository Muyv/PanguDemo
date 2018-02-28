
package com.joindata.demo.pangu.rabbitmq.mq;

import org.springframework.stereotype.Component;

import com.joindata.demo.pangu.rabbitmq.biz.entity.Contact;
import com.joindata.inf.common.sterotype.mq.MessageListener;
import com.joindata.inf.common.sterotype.mq.annotation.Queue;
import com.joindata.inf.common.support.rabbitmq.annotation.RabbitAttr;
import com.joindata.inf.common.support.rabbitmq.enums.RabbitFeature;
import com.joindata.inf.common.util.log.Logger;

/**
 * 从 RabbitMQ 中订阅 CRM.CONTACT 主题收取 JSON 格式数据
 * 
 * @author <a href="mailto:songxiang@joindata.com">宋翔</a>
 * @date Apr 14, 2017 4:08:14 PM
 */
@Component
@Queue("CRM.CONTACT")
// 注意这里的 RabbitFeature.JsonSerialization，如果发送方用 JSON 序列化，这里也必须指定用 JSON 反序列化
@RabbitAttr(exchangeName = "PANGU.DIRECT", routingKey = "contact", features = RabbitFeature.JsonSerialization)
public class ContactListener implements MessageListener<Contact>
{
    private static final Logger log = Logger.get();

    @Override
    public void onReceive(Contact contact)
    {
        log.info("收到联系人 {} 的相关数据: {}", contact.getName(), contact);
    }
}
