<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试作用域</title>
</head>
<body>

    <%-- pageContext当前页面的上下文对象 --%>
    <%
        pageContext.setAttribute("name","沙悟净");
    %>


    当前页面作用域：${pageScope.name} <br>
    请求作用域：${requestScope.name}  <br>
    会话作用域：${sessionScope.name}  <br>
    上下文作用域：${applicationScope.name}  <br>

    <%--  所有作用域中都有name属性，显示pageContext的值 --%>
    ${name}   <br>

    <%-- 作用域中不存在的值,EL表达式直接不显示 --%>
    ${str}    <br>

</body>
</html>
