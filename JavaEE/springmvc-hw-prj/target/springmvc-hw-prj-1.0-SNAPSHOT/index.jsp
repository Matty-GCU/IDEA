<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>首页</title>
    <meta charset="UTF-8">
</head>
<body>
    <%-- 需要做登录校验 --%>
    <a href="${pageContext.request.contextPath}/books">书籍管理</a><br>
    <%-- 不需要做登录校验 --%>
    <a href="${pageContext.request.contextPath}/user/toLogin">书籍管理员登录</a>
</body>
</html>
