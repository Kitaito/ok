package com.igeek.javaee.ch02.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 编码集过滤器
 * @WebFilter  过滤器
 * filterName参数：过滤器的名称，决定当前应用的执行过滤器的顺序
 * urlPatterns参数：设置过滤器的过滤路径
 * initParams参数：过滤器初始化参数  name是参数的键，value是参数的值
 */
@WebFilter(filterName = "f1" , urlPatterns = "/*" ,
        initParams = {@WebInitParam(name="encode",value = "UTF-8")})
public class EncodeFilter implements Filter {

    private String encode;

    public EncodeFilter(){
        System.out.println("编码集过滤器  EncodeFilter()");
    }

    public void destroy() {
        System.out.println("编码集过滤器 destroy()");
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
        System.out.println("编码集过滤器 init()");
        encode = config.getInitParameter("encode");
        System.out.println("encode = "+encode);
    }

}
