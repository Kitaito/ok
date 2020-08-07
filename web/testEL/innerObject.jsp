<%--
  Created by IntelliJ IDEA.
  User: cp
  Date: 2020/8/7
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试内置对象</title>
</head>
<body>
        <%--  1~4.作用域的内置对象 --%>
        <%
            pageContext.setAttribute("name","a");    //只在当前页面

            request.setAttribute("name","b");    //一次请求中，可以请求转发

            session.setAttribute("name","c");    //会话超时之前都存在，只要浏览器不关闭

            application.setAttribute("name","d");    //服务器重启或关闭前都存在，只要服务器不关闭
        %>

        EL表达式取name:
        ${pageScope.name }
        ${requestScope.name }
        ${sessionScope.name }
        ${applicationScope.name }


        <br><hr>
        <%-- 5~6.获取用户提交的请求参数param/paramValues --%>
        ${param.username}
        ${paramValues.hobby[1]}


        <br><hr>
        <%-- 7~8.获取请求头中的信息 header/headerValues --%>
        ${header}<br>
        ${headerValues.cookie[0]}<br>
        ${headerValues.host[0]}<br>


        <br><hr>
        <%-- 9.cookie内置对象 --%>
        <%-- ${cookie}获取了cookie数组，获取所有的cookie数据。 --%>
        ${cookie}<br>

        <%-- 若要获取数组中的指定cookie，使用点名称的方式获取 --%>
        ${cookie.JSESSIONID.name}
        ${cookie.JSESSIONID.value}<br>
        ${cookie.name.name}
        ${cookie.name.value}

        <br><hr>
        <%-- 10.pageContext内置对象  --%>
        ${pageContext.request.contextPath}   <%-- /javaee  --%>


        <br><hr>
        <%-- 11.initParam内置对象 --%>
        ${initParam}
        ${initParam.version}
        ${initParam.address}


</body>
</html>
