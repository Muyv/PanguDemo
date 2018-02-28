
package com.joindata.demo.pangu.rabbitmq.mq;

import org.springframework.stereotype.Component;

import com.joindata.inf.common.sterotype.mq.MessageListener;
import com.joindata.inf.common.sterotype.mq.annotation.Broadcast;
import com.joindata.inf.common.support.rabbitmq.annotation.RabbitAttr;
import com.joindata.inf.common.support.rabbitmq.enums.RabbitFeature;
import com.joindata.inf.common.util.log.Logger;

/**
 * 从 RabbitMQ 中订阅 CRM.NEWS 广播收取新闻数据
 * 
 * @author <a href="mailto:songxiang@joindata.com">宋翔</a>
 * @date Apr 14, 2017 4:08:14 PM
 */
@Component
@Broadcast("CRM.NEWS")
@RabbitAttr(exchangeName = "PANGU.FANOUT", routingKey = "frontpage", features = RabbitFeature.SharedBroadcastQueue)
public class NewsListener implements MessageListener<String>
{
    private static final Logger log = Logger.get();

    @Override
    public void onReceive(String message)
    {
        log.info("现在插播最新新闻: {}", message);
    }
}
