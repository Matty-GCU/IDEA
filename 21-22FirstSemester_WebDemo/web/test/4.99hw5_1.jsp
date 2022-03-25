<%@ page language="java" contentType="text/html; charset=UTF-8"
    errorPage="4.99hw5_2.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		errorPage测试（看是否会跳转到通用处理页面）<br>
		<%
			int a = 10;
			int b = a / 0;
		%>
	</body>
</html>