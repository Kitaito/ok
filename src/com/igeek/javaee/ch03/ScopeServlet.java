package com.igeek.javaee.ch03;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ScopeServlet" , urlPatterns = "/scope")
public class ScopeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求作用域
        request.setAttribute("name","唐僧");

        //会话作用域
        HttpSession session = request.getSession();
        session.setAttribute("name","孙悟空");

        //当前应用上下文作用域
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("name","八戒");

        //请求转发至scope.jsp页面
        request.getRequestDispatcher("testEL/scope.jsp").forward(request,response);

    }
}
