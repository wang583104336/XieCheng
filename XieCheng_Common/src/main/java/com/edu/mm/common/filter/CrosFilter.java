package com.edu.mm.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基于消息头实现跨域问题
 */
public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CROS...");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");//支持跨域的域名  *任意
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");//请求方式
        response.setHeader("Access-Control-Allow-Headers", "x-request-with");//消息头
        response.setHeader("Access-Control-Max-Age", "1800");//时间  单位秒
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
