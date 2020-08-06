<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <%
        String username = null;
        String password = null;

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie!=null){
                    if(cookie.getName().equals("name")){
                        //对于存储中文的cookie需要进行解码
                        username = URLDecoder.decode(cookie.getValue(),"UTF-8");
                    }
                    if(cookie.getName().equals("pwd")){
                        password = cookie.getValue();
                    }
                }
            }
        }

        if(username!=null && password!=null){
            //直接跳转至UserServlet中进行登录
            request.getRequestDispatcher("user?code=login&username="+username+"&password="+password).forward(request,response);
        }

    %>



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
            <tr>
                <td>选择免登录时间</td>
                <td>
                    <select name="timeLength">
                        <option value="0">每次自行登录</option>
                        <option value="7">7天内免登录</option>
                        <option value="15">15天内免登录</option>
                    </select>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="登录" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
