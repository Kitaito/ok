<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%-- 通过isErrorPage属性，一旦设置true，则表示可以有内置对象Exception产生 --%>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
    出现错误信息为：
    <%= exception.getMessage() %>
</body>
</html>
