<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<font color="blue">${requestScope.message}</font>
<!--  enctype="multipart/form-data" 表示以二进制的数据格式来传输  -->
<form class="registForm"> 
	<table border="1px" cellspacing="0" cellpadding="10px" align="center">
		<tr>
			<td colspan="3" align="center"><h1>注册页面</h1></td>
		</tr>
		<tr>
			<td>username</td>
			<td>
				<input type="text" name="name" class="name" onblur="validateRegistName()"/>
				<span class="namemsg"></span>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="button" onclick="registController('${pageContext.request.contextPath }')" value="注册"/>&nbsp;&nbsp;
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>