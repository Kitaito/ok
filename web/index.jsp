<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index.jsp</title>
  </head>
  <body>
      <form action="first" method="post">
        username:<input type="text" name="username" placeholder="请输入用户名" /><br>
        password:<input type="password" name="password" /><br>
        hobby:
          <input type="checkbox" name="hobby" placeholder="请输入用户名" value="ball" />篮球
          <input type="checkbox" name="hobby" placeholder="请输入用户名" value="music" />音乐
          <input type="checkbox" name="hobby" placeholder="请输入用户名" value="coding" />编程
        <br>
        <input type="submit" value="提交" />
      </form>

      <%--
          总结：不同提交方式
          1. 超链接访问资源，提交方式get方式，执行servlet中的doGet()
          2. 通过地址栏直接访问http://localhost:8899/javaee/first，提交方式get方式，执行servlet中的doGet()
          3. 表单method指定是get方式，执行servlet中的doGet()
             表单method指定post方式，执行servlet中的doPost()
       --%>
      <a href="first?username=李四&password=111">访问FirstServlet</a>

  </body>
</html>
