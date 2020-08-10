package com.igeek.javaee.ch04.items.servlet;

import com.igeek.javaee.ch04.items.entity.User;
import com.igeek.javaee.ch04.items.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserServlet" , urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserService();
        HttpSession session = request.getSession();

        String code = request.getParameter("code");
        if(code!=null && !code.equals("")){
            switch (code){
                //登录
                case "login":
                    //获得请求参数
                    String username = request.getParameter("username");
                    String address = request.getParameter("address");

                    //实现登录
                    User user = service.login(username, address);
                    if(user!=null){
                        session.setAttribute("user",user);
                        request.getRequestDispatcher("items/main.jsp").forward(request,response);
                    }else{
                        request.setAttribute("msg","用户名和地址不匹配");
                        request.getRequestDispatcher("items/login.jsp").forward(request,response);
                    }

                    break;
                case "logout":
                    session.invalidate();
                    request.setAttribute("msg","已登出");
                    request.getRequestDispatcher("items/login.jsp").forward(request,response);
                    break;
                case "regist":
                    break;
                default:
                    System.out.println("无此操作！");
                    break;
            }
        }else{
            System.out.println("未指定操作！");
        }

    }
}
