<%--
  Created by IntelliJ IDEA.
  User: Matty's PC
  Date: 2022/1/4
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>不使用AJAX技术的跳转效果</title>
</head>
<body>
    <script type="text/javascript">
        function showInfo() {
            window.location = "../index.jsp";
        }
    </script>
    <input type="button" value="跳转到欢迎页面" onClick="showInfo()">
</body>
</html>
