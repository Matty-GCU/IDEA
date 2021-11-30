<%--
  Created by IntelliJ IDEA.
  User: Matty's PC
  Date: 2021/11/30
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="stu" class="chapter10.javabean.StudentVO" scope="page">
</jsp:useBean>
<jsp:setProperty name="stu" property="name" value="小明"/>
<jsp:setProperty name="stu" property="id" value="123"/>
<jsp:getProperty name="stu" property="id"/>
<html>
<head>
    <title>测试一下JavaBean（即StudentVO）</title>
</head>
<body>
    <%
        System.out.println(stu.getId());
        System.out.println(stu.getName());
    %>
</body>
</html>
