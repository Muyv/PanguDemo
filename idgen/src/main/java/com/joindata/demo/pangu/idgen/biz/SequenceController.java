package com.joindata.demo.pangu.idgen.biz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.inf.common.support.idgen.annotation.Sequence;
import com.joindata.inf.common.support.idgen.component.sequence.impl.DailySequence;
import com.joindata.inf.common.support.idgen.component.sequence.impl.DefaultSequence;
import com.joindata.inf.common.support.idgen.component.sequence.impl.PrefixSequence;
import com.joindata.inf.common.support.idgen.component.sequence.impl.TimestampPrefixSequence;
import com.joindata.inf.common.support.idgen.component.sequence.impl.TimestampSequence;

@RestController
@RequestMapping("/sequence")
public class SequenceController
{
    /** 5位日期戳+2位命名空间前缀+序列值 */
    @Sequence("ORDER_ID")
    private TimestampPrefixSequence orderIdSequence;

    /** 2位命名空间前缀+序列值 */
    @Sequence("USER_ID")
    private PrefixSequence userIdSequence;

    /** 2位命名空间前缀+序列值 */
    @Sequence("STORE_ID")
    private PrefixSequence storeIdSequence;

    /** 5位日期戳+序列值 */
    @Sequence("PAY_ID")
    private TimestampSequence payIdSequence;

    /** 纯粹序列值 */
    @Sequence("SERIAL_NO")
    private DefaultSequence serialNoSequence;

    @Sequence("DAILY_SERIAL_NO")
    private DailySequence dailySequence;

    @GetMapping("/ORDER_ID/next")
    public long nextOrderId()
    {
        System.out.println("fk you sonaaaaaaaang !!!!!!!!!!");
        return orderIdSequence.next();
    }

    @GetMapping("/USER_ID/next")
    public long nextUserId()
    {
        return userIdSequence.next();
    }

    @GetMapping("/STORE_ID/next")
    public long nextStoreId()
    {
        return storeIdSequence.next();
    }

    @GetMapping("/PAY_ID/next")
    public long nextPayId()
    {
        return payIdSequence.next();
    }

    @GetMapping("/SERIAL_NO/next")
    public long nextSerialNo()
    {
        return serialNoSequence.next();
    }

    @GetMapping("/DAILY_SERIAL_NO/next")
    public long nextDailySerialNo()
    {
        return dailySequence.next();
    }
}
