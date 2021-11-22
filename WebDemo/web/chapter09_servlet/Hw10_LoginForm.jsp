<%--
  Created by IntelliJ IDEA.
  User: Matty's PC
  Date: 2021/11/17
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>作业10用户登录页面</title>
</head>
<body>
<form action="/WebDemo/Hw10/ControllerServlet" method="post">
    message: <%=request.getAttribute("message")%><br>
    用户登录：<br>
    <input type="text" name="userName"><br>
    <input type="text" name="userPassword"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
