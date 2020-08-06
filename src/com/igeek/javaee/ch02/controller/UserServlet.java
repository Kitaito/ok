package com.igeek.javaee.ch02.controller;

import com.igeek.javaee.ch02.entity.User;
import com.igeek.javaee.ch02.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

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
        //获得会话
        HttpSession session = request.getSession();

        //获取请求参数
        String code = request.getParameter("code");

        if(code!=null && !code.equals("")){

            switch (code){
                //登录操作
                case "login":
                    //获取请求参数
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String timeLength = request.getParameter("timeLength");

                    //设置默认都是需要密码登录
                    int time = 0;
                    if(timeLength!=null){
                        //若页面上选择了免登录时间，则获取值
                        time = Integer.parseInt(timeLength);
                    }

                    if(username!=null && !username.trim().equals("") && password!=null && !password.trim().equals("")){
                        //登录
                        User user = service.login(username, password);

                        if(user!=null){
                            //若查询到用户信息

                            //设置Cookie
                            //1.创建Cookie对象  若有中文，对存储进来的Cookie进行编码
                            Cookie nameCookie = new Cookie("name", URLEncoder.encode(username,"UTF-8"));
                            Cookie pwdCookie = new Cookie("pwd",password);

                            //2.设置Cookie有效期（单位秒），保存在浏览器所在的PC硬盘上
                            nameCookie.setMaxAge(time*24*60*60);
                            pwdCookie.setMaxAge(time*24*60*60);

                            //3.将Cookie添加至响应中response
                            response.addCookie(nameCookie);
                            response.addCookie(pwdCookie);

                            //设置会话属性
                            session.setAttribute("user",user);

                            //跳转至成功页面
                            request.getRequestDispatcher("success.jsp").forward(request,response);
                        }else{
                            //若未查询到用户信息
                            request.setAttribute("msg","用户名和密码不匹配，请重新登录");
                            request.getRequestDispatcher("login.jsp").forward(request,response);
                        }
                    }else{
                        request.setAttribute("msg","用户名或密码为空，请重新登录");
                        request.getRequestDispatcher("login.jsp").forward(request,response);
                    }

                    break;
                //登出
                case "logout":
                    //会话销毁
                    session.invalidate();
                    request.setAttribute("msg","已退出，请重新登录");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                    break;
                default:
                    break;
            }

        }else{
            System.out.println("没有匹配的动作！");
        }

    }

}
