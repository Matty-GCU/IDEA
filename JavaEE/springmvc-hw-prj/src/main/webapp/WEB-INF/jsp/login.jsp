<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    书籍管理员登录
    <form:form modelAttribute="user" action="${pageContext.request.contextPath}/user/login">
        账号：<form:input path="userName"/>
        密码：<form:password path="pswd"/>
        <input type="submit" value="登录">
    </form:form>
</body>
</html>
