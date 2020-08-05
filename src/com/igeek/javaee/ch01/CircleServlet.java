package com.igeek.javaee.ch01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet的生命周期
 * 1.实例化 (有且仅有一次)
 * 2.初始化 (有且仅有一次)
 * 3.通过地址栏直接访问，执行了doGet()
 * 4.再次通过地址栏直接访问，执行了doGet()
 * 5.关闭程序，执行销毁
 */
@WebServlet(name = "CircleServlet" , urlPatterns = "/circle" ,initParams = {@WebInitParam(name="version",value="1.0")})
public class CircleServlet extends HttpServlet {

    //构造函数：实例化对象会进行调用
    public CircleServlet() {
        System.out.println("实例化 CircleServlet()");
    }

    //销毁方法
    @Override
    public void destroy() {
        System.out.println("销毁方法 destroy() ");
    }

    //初始化方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        String version = config.getInitParameter("version");
        System.out.println("version = "+version);
        System.out.println("初始化方法 init()");
    }

    //doPost()
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()");
    }


    //doGet()
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");
    }
}
