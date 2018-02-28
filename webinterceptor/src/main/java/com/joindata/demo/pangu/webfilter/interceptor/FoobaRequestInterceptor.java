package com.joindata.demo.pangu.webfilter.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joindata.demo.pangu.webfilter.biz.service.RequestLogService;
import com.joindata.inf.boot.sterotype.annotations.WebRequestInterceptor;
import com.joindata.inf.boot.sterotype.handler.RequestInterceptor;
import com.joindata.inf.common.basic.exceptions.GenericException;
import com.joindata.inf.common.util.log.Logger;

@Component
@WebRequestInterceptor(exclude = "/foo/other") // 注意这个注解
public class FoobaRequestInterceptor extends RequestInterceptor
{
    private static final Logger log = Logger.get();

    // 可以注入 Spring 托管的 Bean
    @Autowired
    private RequestLogService requestLogService;

    @Override
    protected void beforeRequest(HttpServletRequest request) throws GenericException
    {
        requestLogService.print();
        log.info("请求进来了: {}", request.getServletPath());
    }

}
