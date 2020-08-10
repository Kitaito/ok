package com.igeek.javaee.ch04.items.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "f1" , urlPatterns = "/*" ,
        initParams = {@WebInitParam(name="encode",value = "UTF-8")})
public class EncodeFilter implements Filter {

    private String encode;

    public EncodeFilter(){

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("编码集过滤器 doFilter()");
        //对请求做编码集处理
        req.setCharacterEncoding(encode);
        //对响应的编码集处理
        resp.setContentType("text/html;charset="+encode);
        //将处理好的请求和响应通过过滤链继续传递下去
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("encode");
    }

}
