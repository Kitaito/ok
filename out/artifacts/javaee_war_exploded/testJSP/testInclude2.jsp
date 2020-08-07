<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试动态包含（标准动作）</title>
</head>
<body>
    <%--
         动态包含：
         1.发生在请求阶段，将包含的main.jsp文件直接翻译成Java文件
         2.include 标准动作
         3.通过page属性来指定包含的页面，同时允许在指定的URL后面追加参数，类似于main.jsp?x=10
    --%>
    <%--<jsp:include page="demo.jsp">
        <jsp:param name="x" value="10"/>
        <jsp:param name="y" value="5"/>
    </jsp:include>--%>

    <%-- JSP标准动作：请求转发 --%>
    <%-- jsp:param  一般当做include和forward的子动作 --%>
    <jsp:forward page="demo.jsp">
        <jsp:param name="x" value="20"/>
        <jsp:param name="y" value="5"/>
    </jsp:forward>

</body>
</html>
