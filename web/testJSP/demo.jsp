<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%-- 通过errorPage属性，指定错误页面error.jsp，一旦发生异常则直接跳转至error.jsp --%>
<html>
<head>
    <title>测试出现异常</title>
</head>
<body>
    <%
        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));
    %>

    <%= x/y %>
</body>
</html>
