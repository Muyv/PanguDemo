package com.joindata.demo.pangu.dubbo.consumer.biz;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.joindata.demo.pangu.dubbo.provider.biz.DubboProviderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dubbo")
public class DubboConsumerController
{
    @Reference
    private DubboProviderService providerService;

    @ApiOperation("远程调用服务生成 UUID")
    @PostMapping("/")
    public String[] generateUuid(@RequestParam int count)
    {
        return providerService.generateUuid(count);
    }
}
