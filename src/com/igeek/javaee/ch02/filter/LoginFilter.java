package com.igeek.javaee.ch02.filter;

import com.igeek.javaee.ch02.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * 登录访问控制
 * 1.@WebFilter 过滤器注解
 * 2.filterName参数 ： 过滤器名称，若项目有多个过滤器，将按照过滤器名字来进行排序
 * 3.urlPatterns参数 ： 过滤资源的路径
 * 4.initParams参数： 过滤器的初始化参数，允许配置多个
 */
@WebFilter(filterName = "f2" , urlPatterns = {"/success.jsp","/index.jsp"} ,
        initParams = {@WebInitParam(name="begin",value="11"),@WebInitParam(name="end",value="12")})
public class LoginFilter implements Filter {

    private int begin;
    private int end;

    public LoginFilter(){
        System.out.println("登录访问控制  LoginFilter()");
    }

    public void destroy() {
        System.out.println("登录访问控制  过滤器销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("登录访问控制 doFilter()");
        HttpSession session = ((HttpServletRequest) req).getSession();
        User user = (User)session.getAttribute("user");

        Date date = new Date();
        int hours = date.getHours();
        if(hours>=begin && hours<=end){
            if(user==null){
                req.setAttribute("msg","访问该资源前，必须先登录！");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
                return;
            }
        }

        //过滤器链：可以将当前处理后的请求、响应继续向下传递，有可能下一个传递到的是过滤器，也有可能是目标资源
        chain.doFilter(req, resp);
    }

    //初始化方法，有且只会执行一次
    public void init(FilterConfig config) throws ServletException {
        System.out.println("登录访问控制  过滤器初始化");
        begin = Integer.parseInt(config.getInitParameter("begin"));
        end = Integer.parseInt(config.getInitParameter("end"));
        System.out.println("begin = "+begin+" , end = "+end);
    }

}
