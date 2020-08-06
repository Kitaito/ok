<%@ page import="com.igeek.javaee.ch02.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    <%
        //登录访问控制
        User user = (User)session.getAttribute("user");
        if(user==null){
            response.sendRedirect("login.jsp");
        }
    %>

    <%-- 测试请求转发携带数据 ， 请求参数中获取值 --%>
    <h1 style="color: green">成功 欢迎${param.username} </h1>

    <%-- 从会话域（会话属性）中获取值 --%>
    <%-- 登出 --%>
    <h1 style="color: cadetblue"><a href="user?code=logout">${sessionScope.user.name}</a></h1>

    <%-- 访问资源：一旦阻止cookie，session会失效，必须重写URL，强制给地址追加上JSESSIONID --%>
    <a href="<%= response.encodeURL("index.jsp") %>">访问index.jsp页面</a>

    <%-- 统计访问人次 --%>
    登录访问的人数：<%= application.getAttribute("counts") %>

    <%--  获取上下文参数 --%>
    获取上下文参数:<%= application.getInitParameter("version") %>
    获取上下文参数:${initParam.version}
</body>
</html>
