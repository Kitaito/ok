<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 使用核心标签库，引入标签库到jsp页面中 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试c:if标签</title>
</head>
<body>

    <%--
        相当于Java中的if(  ){  }
        test属性：判断是否执行标签内的内容（true则执行标签中的内容，false则不执行）。

        var属性：用来保存test属性的结果（使用var属性给他取个名字），这个结果可以保存到指定的容器中。（如果没有指定容器，默认存入page容器中）

        scope属性：指定保存数据的容器。
    --%>
    <c:if test="${1<2}" var="flag" scope="session">
        <h1>测试c:if标签，test返回true，成立</h1>
    </c:if>

    pageScope: ${pageScope.flag} <br>
    requestScope: ${requestScope.flag}  <br>
    sessionScope:${sessionScope.flag}   <br>  <%-- true --%>
    applicationScope:${applicationScope.flag}  <br>


</body>
</html>
