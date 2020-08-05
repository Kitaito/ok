package com.igeek.javaee.ch01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirstServlet" , urlPatterns = {"/first"})
public class FirstServlet extends HttpServlet {

    /**
     * doPost方法
     * @param request  请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()");

        //处理中文乱码
        request.setCharacterEncoding("UTF-8");

        //获得请求参数(一般用于接收浏览器传过来的值)
        //获得一个请求参数的值： 请求.getParameter("form表单中name属性的值")
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username="+username+" , password="+password);

        //获得一组请求参数的值： 请求.getParameterValues("form表单中name属性的值")
        /*String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        // 没有JSP页面之前的处理方式： 生成动态页面  响应信息（一般用于将数据响应到页面上显示）
        /*if (username!=null && !username.equals("") && password!=null && !password.equals("")) {
            response.getWriter().write("success");
        }else{
            response.getWriter().write("fail");
        }*/

        //页面跳转
        if (username!=null && !username.equals("") && password!=null && !password.equals("")) {
            //请求属性：将数据传递至页面
            request.setAttribute("msg","成功访问，Hello Success");
            //请求转发：地址栏不会发生变化，会显示请求地址/first，延续之前的请求，携带数据的
            request.getRequestDispatcher("success.jsp").forward(request,response);

            //响应重定向：地址栏会发生变化，会显示目标地址/success.jsp，会产生新的请求，不携带数据，避免重复提交表单
            //response.sendRedirect("success.jsp");
        }else{
            //请求属性：将数据传递至页面
            request.setAttribute("msg","访问失败，Hello Error");
            request.getRequestDispatcher("fail.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()");
        this.doPost(request,response);
    }

}
