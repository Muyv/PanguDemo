package com.joindata.demo.pangu.dubbo.provider.biz;

public interface DubboProviderService
{
    /**
     * 生成一些 UUID
     * 
     * @param count 生成几个
     * @return 生成后的 UUID 数组
     */
    public String[] generateUuid(int count);
}
