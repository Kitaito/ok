<%@ page import="java.util.*" %>
<%@ page import="com.igeek.javaee.ch02.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试复杂数据</title>
</head>
<body>

    <%-- 案例1：复杂数据 - 数组 --%>
    <%
        int[] arr = {111,222,333,444,555};
        pageContext.setAttribute("arr",arr);
    %>
    <h1 style="color: maroon">访问数组元素，可以通过下标操作：${arr[0]}</h1>


    <br><hr>
    <%-- 案例2：复杂数据 - 集合List --%>
    <%
        List list = new ArrayList();
        list.add("鼠标");
        list.add("电脑");
        list.add("键盘");
        pageContext.setAttribute("list",list);
    %>
    <h1 style="color:cadetblue;">访问List集合元素，可以通过下标操作：${list[1]}</h1>


    <br><hr>
    <%-- 案例3：复杂数据 - 集合Map --%>
    <%
        Map map = new TreeMap();
        map.put("v111","火锅");
        map.put("v333","烤肉");
        map.put("v222","日料");
        map.put("v444","炒菜");
        pageContext.setAttribute("map",map);
    %>
    <h1 style="color:olive;">访问Map集合元素，通过key获取value：${map.v111}</h1>
    <h1 style="color:olive;">访问Map集合元素，通过key获取value：${map["v222"]}</h1>


    <br><hr>
    <%-- 案例4：复杂数据 - 自定义的类 --%>
    <%
        User user = new User();
        user.setName("李四");
        user.setPwd("123");
        pageContext.setAttribute("user",user);
    %>
    <h1 style="color:lightcoral;">获取User信息：${user}</h1>
    <h1 style="color:lightcoral;">获取User的姓名：${user.name}</h1>
    <h1 style="color:lightcoral;">获取User的密码：${user["pwd"]}</h1>


</body>
</html>
