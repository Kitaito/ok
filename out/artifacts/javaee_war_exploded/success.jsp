<%--
  Created by IntelliJ IDEA.
  User: cp
  Date: 2020/8/5
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    <h1 style="color: green">成功 欢迎${param.username} </h1>

    <%-- 从请求域（请求属性）中获取值 --%>
    <h1 style="color: cadetblue">${requestScope.msg}</h1>
</body>
</html>
