package com.joindata.demo.pangu.webfilter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joindata.demo.pangu.webfilter.biz.service.RequestLogService;
import com.joindata.inf.common.basic.annotation.FilterComponent;
import com.joindata.inf.common.util.log.Logger;

@Component
@FilterComponent(path = "/foo/*") // 记住这个注解
public class RequestFilter implements Filter // 实现 java.servlet.Filter
{
    private static final Logger log = Logger.get();

    // 可以注入 Spring 托管的 Bean
    @Autowired
    private RequestLogService requestLogService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        log.info("Filter 初始化了...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        log.info("进入 Filter 了, 请求路径: {}", ((HttpServletRequest)request).getServletPath());

        log.info("请求参数: {}", request.getParameterMap());

        log.info("请求长度: {}", request.getContentLengthLong());

        requestLogService.print();

        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {
        log.info("Filter 挂了...");
    }

}
