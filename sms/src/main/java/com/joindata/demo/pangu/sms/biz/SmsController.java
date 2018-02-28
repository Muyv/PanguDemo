package com.joindata.demo.pangu.sms.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.sms.biz.entity.SmsSendParam;
import com.joindata.demo.pangu.sms.biz.service.SmsService;

import io.swagger.annotations.ApiOperation;

@RestController
public class SmsController
{
    @Autowired
    private SmsService smsService;

    @ApiOperation("发送短信给某手机号")
    @PostMapping("/sms/$/send")
    public void send(@RequestBody SmsSendParam param)
    {
        smsService.send(param.getMobile(), param.getContent());
    }

    @ApiOperation("发送短信给某手机号，并使用短信模板")
    @PostMapping("/sms/{templateId}/send")
    public void send(@PathVariable int templateId, @RequestBody SmsSendParam param)
    {
        smsService.send(param.getMobile(), templateId);
    }
}
