<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
</head>
<body>
<h1 style="color: red">${requestScope.msg}</h1>
<form class="loginForm" action="" method="post">
	<table border="1px" cellspacing="0" cellpadding="10px" align="center">
		<tr>
			<td colspan="2" align="center"><h1>登陆页面</h1></td>
		</tr>
		<tr>
			<td>username</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>address</td>
			<td><input type="text" name="address"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="登陆" onclick="loginServlet('${pageContext.request.contextPath}/users?code=login')"/>&nbsp;&nbsp;
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
</form> 
</body>
</html>