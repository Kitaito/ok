<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="obj.jsp" isErrorPage="true" %>
<html>
<head>
    <title>测试内置对象</title>
</head>
<body>
   <%= request.getRemoteAddr() %> <br>
   <%= request.getParameter("x") %> <br>

    <%-- 上下文对象 --%>
    <%= application.getInitParameter("version") %> <br>
    ${initParam.version} <br>

    <%-- 异常信息 exception能够使用，配合isErrorPage="true"才可以 --%>
    <%= exception.printStackTrace()%>

</body>
</html>
