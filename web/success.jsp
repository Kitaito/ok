<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    <%-- 测试请求转发携带数据 ， 请求参数中获取值 --%>
    <h1 style="color: green">成功 欢迎${param.username} </h1>

    <%-- 从请求域（请求属性）中获取值 --%>
    <h1 style="color: cadetblue">${requestScope.user.name}</h1>
</body>
</html>
