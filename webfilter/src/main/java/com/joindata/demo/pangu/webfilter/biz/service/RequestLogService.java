package com.joindata.demo.pangu.webfilter.biz.service;

import org.springframework.stereotype.Service;

import com.joindata.inf.common.util.log.Logger;

@Service
public class RequestLogService
{
    private static final Logger log = Logger.get();

    public void print()
    {
        log.info("收到一个请求了...");
    }
}
