package com.joindata.demo.pangu.dubbo.provider.biz.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.joindata.demo.pangu.dubbo.provider.biz.DubboProviderService;
import com.joindata.inf.common.util.tools.UuidUtil;

@Service
public class DubboProviderProviderImpl implements DubboProviderService
{
    @Override
    public String[] generateUuid(int count)
    {
        return UuidUtil.make(count);
    }
}
