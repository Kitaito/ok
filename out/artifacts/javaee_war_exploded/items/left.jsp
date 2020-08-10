<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul>
	<li onclick="login()">登陆</li>
	<li onclick="regist()">注册</li>
	<li onclick="logout('${pageContext.request.contextPath}/users?code=logout')">退出</li>
	<li onclick="viewAll('${pageContext.request.contextPath}/items?code=viewAll')">查看商品所有</li>
</ul>