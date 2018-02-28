package com.joindata.demo.pangu.dubbo.consumer.filter;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.joindata.inf.common.util.log.Logger;

public class ConsumerFilter implements Filter
{
    private static final Logger log = Logger.get();

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException
    {
        log.info("拦截到消费了: {}", invocation.getMethodName());
        return invoker.invoke(invocation);
    }

}
