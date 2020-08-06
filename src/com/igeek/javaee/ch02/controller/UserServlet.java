package com.igeek.javaee.ch02.controller;

import com.igeek.javaee.ch02.entity.User;
import com.igeek.javaee.ch02.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet" , urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码集
        request.setCharacterEncoding("UTF-8");
        //创建业务逻辑对象
        UserService service = new UserService();

        //获取请求参数
        String code = request.getParameter("code");

        if(code!=null && !code.equals("")){

            switch (code){
                case "login":
                    //登录
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    if(username!=null && !username.trim().equals("") && password!=null && !password.trim().equals("")){
                        User user = service.login(username, password);
                        if(user!=null){
                            request.setAttribute("user",user);
                            request.getRequestDispatcher("success.jsp").forward(request,response);
                        }else{
                            request.setAttribute("msg","用户名和密码不匹配，请重新登录");
                            request.getRequestDispatcher("login.jsp").forward(request,response);
                        }
                    }else{
                        request.setAttribute("msg","用户名或密码为空，请重新登录");
                        request.getRequestDispatcher("login.jsp").forward(request,response);
                    }

                    break;
                case "register":
                    break;
                default:
                    break;
            }

        }else{
            System.out.println("没有匹配的动作！");
        }

    }

}
