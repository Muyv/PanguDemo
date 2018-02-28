package com.joindata.demo.pangu.sms.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joindata.demo.pangu.sms.biz.service.SmsService;
import com.joindata.inf.common.support.sms.component.SmsClient;
import com.joindata.inf.common.support.sms.pojo.SmsTemplate;
import com.joindata.inf.common.util.basic.StringUtil;
import com.joindata.inf.common.util.log.Logger;
import com.joindata.inf.common.util.tools.RandomUtil;

@Service
public class SmsServiceImpl implements SmsService
{
    @SuppressWarnings("unused")
    private static final Logger log = Logger.get();

    @Autowired
    private SmsClient smsClient;

    @Override
    public void send(String mobile, String content)
    {
        smsClient.send(content, StringUtil.splitToArray(mobile));
    }

    @Override
    public void send(String mobile, int templateId)
    {
        smsClient.send(SmsTemplate.of(templateId).withParam("code", RandomUtil.randomNumeric(6)), mobile);
    }

}
