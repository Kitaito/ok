<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试静态包含（指令）</title>
</head>
<body>
    <%--
         静态包含：
         1.发生在翻译阶段， 将包含的main.jsp文件翻译进testInclude1.jsp页面中
         2.include 指令
         3.通过file属性来实现包含关系，要求值必须是jsp的文件名且存在
    --%>
    <%@ include file="main.jsp"%>
</body>
</html>
