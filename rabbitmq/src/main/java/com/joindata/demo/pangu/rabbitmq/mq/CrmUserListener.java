
package com.joindata.demo.pangu.rabbitmq.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joindata.demo.pangu.rabbitmq.biz.entity.User;
import com.joindata.demo.pangu.rabbitmq.biz.service.CrmUserService;
import com.joindata.inf.common.sterotype.mq.MessageListener;
import com.joindata.inf.common.sterotype.mq.annotation.Topic;
import com.joindata.inf.common.support.rabbitmq.annotation.RabbitAttr;
import com.joindata.inf.common.util.log.Logger;

/**
 * 从 RabbitMQ 中订阅 CRM.USER 主题收取用户数据
 * 
 * @author <a href="mailto:songxiang@joindata.com">宋翔</a>
 * @date Apr 14, 2017 4:08:14 PM
 */
@Component
@Topic("CRM.USER")
@RabbitAttr(exchangeName = "PANGU.TOPIC", routingKey = "x")
public class CrmUserListener implements MessageListener<User>
{
    private static final Logger log = Logger.get();

    @Autowired
    private CrmUserService crmUserService;

    @Override
    public void onReceive(User user)
    {
        log.info("收到用户 {} 的数据", user.getName());

        crmUserService.saveUser(user);
    }
}
