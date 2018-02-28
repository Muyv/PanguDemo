package com.joindata.demo.pangu.elasticjob.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.elasticjob.job.ManualPrintJob;
import com.joindata.inf.common.support.elasticjob.component.JobHelper;

@RestController
@RequestMapping("/job/Demo - 手动打印任务/_status")
public class ManualJobController
{
    @Autowired
    private JobHelper jobHelper;

    @PostMapping("/start")
    public void start()
    {
        jobHelper.start(ManualPrintJob.class);
    }

    @DeleteMapping("/stop")
    public void stop()
    {
        jobHelper.stop(ManualPrintJob.class);
    }
}
