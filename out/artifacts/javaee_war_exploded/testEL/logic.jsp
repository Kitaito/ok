<%@ page import="com.igeek.javaee.ch02.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: cp
  Date: 2020/8/7
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试运算符</title>
</head>
<body>

        <%-- 演示El执行运算 --%>
        <%
            int x = 3;
            int y = 4;
            //String y = "4g";
            pageContext.setAttribute("x", x);
            pageContext.setAttribute("y", y);
        %>

        <%-- 使用EL表达式获取数据，最终都是讲数据转换成字符串，根据字符串，格式化数字，在进行计算 --%>
        ${x+y }  <%-- 7 --%>
        ${x-y }  <%-- -1 --%>
        ${x*y }  <%-- 12 --%>
        ${x/y }  <%-- 0.75 --%>
        ${x%y }  <%-- 3 --%>

        <hr>

        <%
            boolean flag = true;
            boolean info = false;
            pageContext.setAttribute("flag", flag);
            pageContext.setAttribute("info", info);
        %>

        ${flag && info}  <%--  false --%>

        ${!info}         <%-- true --%>

        ${flag || info}  <%--  true --%>

        <hr>

        ${x < y }    <%-- true --%>
        ${x <= y}    <%-- true --%>
        ${x > y }    <%-- false --%>
        ${x >= y }   <%-- false --%>
        ${x == y }   <%-- false --%>
        ${x != y }   <%-- true --%>

        <hr>

        <%
            User user = new User();
            user.setName("李四");
            user.setPwd("123");
            pageContext.setAttribute("user",user);
        %>

        <%-- 判断user是否为空 --%>
        ${empty user}   <%-- false  --%>

        <%-- 三目运算符 --%>
        ${user!=null ? user.name : ""}  <%-- 李四 --%>

</body>
</html>
