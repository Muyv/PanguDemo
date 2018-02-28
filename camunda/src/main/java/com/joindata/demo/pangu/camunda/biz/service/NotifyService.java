package com.joindata.demo.pangu.camunda.biz.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.joindata.inf.common.util.log.Logger;

@Component
public class NotifyService implements JavaDelegate
{
    private static final Logger log = Logger.get();

    @Override
    public void execute(DelegateExecution execution) throws Exception
    {
        log.info("Received: {}", execution.getProcessInstance());
    }

}
