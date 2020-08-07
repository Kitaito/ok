<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试 c:choose / c:when / c:otherwise 标签</title>
</head>
<body>

    <%-- c:choose  c:when  c:otherwise 相当于：if( ){  }else if( ){ } else if( ){ } ...... else{ } --%>
    <%
        int num = 8;
        pageContext.setAttribute("num",num);
    %>

    <c:choose>

        <c:when test="${num==1}">星期一</c:when>
        <c:when test="${num==2}">星期二</c:when>
        <c:when test="${num==3}">星期三</c:when>
        <c:when test="${num==4}">星期四</c:when>
        <c:when test="${num==5}">星期五</c:when>
        <c:when test="${num==6}">星期六</c:when>
        <c:when test="${num==7}">星期日</c:when>

        <c:otherwise>没有匹配的</c:otherwise>

    </c:choose>


</body>
</html>
