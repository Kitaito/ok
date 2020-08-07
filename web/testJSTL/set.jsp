<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.igeek.javaee.ch02.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: cp
  Date: 2020/8/7
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试c:set和c:out标签</title>
</head>
<body>

    <%--  测试c:set标签 --%>
    <%
        User user = new User();
        user.setName("柯南");
        user.setSex("1");
        pageContext.setAttribute("user",user);
    %>

    <%--
        c:set标签
        1.var:声明了一个变量空间，用来存储数据(value属性的值)的
        2.value：要保存的数据
        3.scope：指定保存在那个容器中
        4.target：指定要修改的对象
        5.property：指定要修改的属性
    --%>
    ${user}<br>
    <%-- 修改用户的性别 --%>
    <c:if test="${user.sex.equals('1')}">
        <c:set target="${user}" property="sex" value="男" var="gender"></c:set>
    </c:if>
    ${gender}<br>
    <%-- 修改用户的名称 --%>
    <c:set target="${user}" property="name" value="张三"></c:set>
    ${user}<br>

    <br><hr>

    <%-- 演示out标签 --%>
    <%	pageContext.setAttribute("str", null); %>

    <%-- default设置没有数据的时候，默认输出 --%>
    <c:out value="${str}" default="《党的纲领性文件学习》"></c:out>

    <%-- escapeXml="true" 让浏览器不解析其中的html--%>
    <c:out value="<a href='http://www.baidu.com'>测试</a>" escapeXml="false"></c:out>

</body>
</html>
