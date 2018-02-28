package com.joindata.demo.pangu.dubbo.provider.filter;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.joindata.inf.common.util.log.Logger;

public class ProviderFilter implements Filter
{
    private static final Logger log = Logger.get();

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException
    {
        log.info("拦截到被调用: {}", invocation.getMethodName());
        return invoker.invoke(invocation);
    }

}
