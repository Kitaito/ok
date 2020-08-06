<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="user?code=login" method="post">
        <table border="1px" cellspacing="0" cellpadding="10px" align="center">
            <tr>
                <th colspan="2">登录界面</th>
            </tr>
            <tr>
                <td>username</td>
                <td>
                    <input type="text" name="username" placeholder="请输入用户名" />
                    <span style="color: maroon">${requestScope.msg}</span>
                </td>
            </tr>
            <tr>
                <td>password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="登录" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
