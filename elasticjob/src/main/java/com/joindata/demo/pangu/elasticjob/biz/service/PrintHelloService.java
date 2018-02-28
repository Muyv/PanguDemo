package com.joindata.demo.pangu.elasticjob.biz.service;

import org.springframework.stereotype.Service;

import com.joindata.inf.common.util.log.Logger;

@Service
public class PrintHelloService
{
    private static final Logger log = Logger.get();

    public void print(String printer)
    {
        log.info("{}: Hello", printer);
    }
}
