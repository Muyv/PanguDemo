package com.joindata.demo.pangu.elasticjob.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.joindata.demo.pangu.elasticjob.biz.service.PrintFoobarService;
import com.joindata.demo.pangu.elasticjob.biz.service.PrintHelloService;
import com.joindata.inf.common.support.elasticjob.annotation.Job;
import com.joindata.inf.common.util.log.Logger;

@Component
@Job(name = "Demo - 手动打印任务", cron = "0/10 * * * * ?", shardingCount = 2, autoRun = false)
public class ManualPrintJob implements SimpleJob
{
    private static final Logger log = Logger.get();

    private static final String PRINTER = "MANUAL-JOB";

    static
    {
        log.warn("请登录 ElasticJob 控制台手动触发以启动任务");
    }

    @Autowired
    private PrintHelloService printHelloService;

    @Autowired
    private PrintFoobarService printFoobarService;

    @Override
    public void execute(ShardingContext context)
    {
        switch(context.getShardingItem())
        {
            case 0:
                printHelloService.print(PRINTER);
                break;
            case 1:
                printFoobarService.print(PRINTER);
                break;
            default:
                log.info("Never Reach ...");
        }
    }

}
