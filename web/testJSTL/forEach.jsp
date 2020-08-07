<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cp
  Date: 2020/8/7
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试c:forEach标签</title>
</head>
<body>

    <%--
        实现 java中for循环的功能
        varStatus:保存了当前循环过程中的信息
    --%>

    <%-- 案例1：foreach 不循环对象（集合、数组）的情况下，单单控制循环的次数 --%>
    <c:forEach begin="2" end="10" step="2" var="temp" varStatus="sta">
        ${sta.index}  <%-- 获得当前迭代的索引位置 --%>
        ${sta.count}  <%-- 获得当前迭代的次数 --%>
        ${sta.first}  <%-- 获得当前是否是迭代的第一项 --%>
        ${sta.last}   <%-- 获得当前是否是迭代的最后一项 --%>
        ${temp}<br>   <%-- 获得当前迭代的元素--%>
    </c:forEach>

    <br><hr>
    <%-- 案例2：循环迭代数组 --%>
    <%
        int[] arr = {111,222,333,444,555};
        pageContext.setAttribute("arr",arr);
    %>

    <%-- items迭代的数组  var临时变量名，保存迭代的数组每项的值 --%>
    <c:forEach items="${arr}" var="a">
        ${a}<br>
    </c:forEach>


    <br><hr>
    <%-- 案例3：循环迭代集合List --%>
    <%
        List list = new ArrayList();
        list.add("鼠标");
        list.add("电脑");
        list.add("键盘");
        pageContext.setAttribute("list",list);
    %>
    <c:forEach items="${list}" var="l">
        ${l}<br>
    </c:forEach>


    <br><hr>
    <%-- 案例4：循环迭代集合Map --%>
    <%
        Map map = new TreeMap();
        map.put("v111","火锅");
        map.put("v333","烤肉");
        map.put("v222","日料");
        map.put("v444","炒菜");
        pageContext.setAttribute("map",map);
    %>
    <c:forEach items="${map}" var="m">
        ${m.key}
        ${m.value}<br>
    </c:forEach>

</body>
</html>
