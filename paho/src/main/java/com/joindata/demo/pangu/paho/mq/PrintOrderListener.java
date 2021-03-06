
package com.joindata.demo.pangu.paho.mq;

import org.springframework.stereotype.Component;

import com.joindata.demo.pangu.paho.biz.entity.Order;
import com.joindata.inf.common.sterotype.mq.MessageListener;
import com.joindata.inf.common.sterotype.mq.annotation.Topic;
import com.joindata.inf.common.support.paho.annotation.PahoAttr;
import com.joindata.inf.common.support.paho.enums.PahoSerialization;
import com.joindata.inf.common.util.log.Logger;

/**
 * 从 Paho 中订阅 PRINTER.ORDER 主题收取数据
 * 
 * @author <a href="mailto:songxiang@joindata.com">宋翔</a>
 * @date Apr 14, 2017 4:08:14 PM
 */
@Component
@Topic("PRINTER.ORDER")
@PahoAttr(serialization = PahoSerialization.Java)
public class PrintOrderListener implements MessageListener<Order>
{
    private static final Logger log = Logger.get();

    @Override
    public void onReceive(Order jsonOrder)
    {
        log.info("收到打印订单的数据: {}", jsonOrder);
    }
}
