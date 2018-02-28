package com.joindata.demo.pangu.webfilter.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.joindata.demo.pangu.webfilter.biz.service.RequestLogService;
import com.joindata.inf.boot.sterotype.annotations.WebRequestInterceptor;
import com.joindata.inf.common.basic.exceptions.GenericException;
import com.joindata.inf.common.util.log.Logger;

/**
 * SpringMVC 版的 Interceptor XXX 注意！不建议使用这种 interceptor，除非要取 UserPrinciple 之类的场景
 */
@Component
@WebRequestInterceptor(exclude = "/foo/other") // 注意这个注解
public class FoobarWebRequestInterceptor extends com.joindata.inf.boot.sterotype.handler.WebRequestInterceptor
{
    private static final Logger log = Logger.get();

    // 可以注入 Spring 托管的 Bean
    @Autowired
    private RequestLogService requestLogService;

    @Override
    protected void beforeRequest(WebRequest request) throws GenericException
    {
        requestLogService.print();
        log.info("请求进来了, 用户: {}", request.getUserPrincipal());
    }

    @Override
    protected void afterRequest(WebRequest request, Exception ex) throws GenericException
    {
        log.info("请求完成了, 用户: {}", request.getUserPrincipal());
    }

}
