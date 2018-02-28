package com.joindata.demo.pangu.sms.biz.service;

public interface SmsService
{
    void send(String mobile, String content);

    void send(String mobile, int id);
}
