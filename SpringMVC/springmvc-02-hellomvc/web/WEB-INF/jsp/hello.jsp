<%--
  Created by IntelliJ IDEA.
  User: Matty's PC
  Date: 2022/4/8
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
    ${result}

    <%-- https://www.zhihu.com/question/36774461/answer/69448526
    自闭合标签来自于XML语法，而不是HTML语法。根据现在的HTML语法，只有不需要结束标签的void element（如img之类的），或者是外部元素（如svg）可以使用自闭合。script标签显然不在此列。 --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/WEB-INF/js/test.js"></script>
    <script>
        test();
    </script>
</body>
</html>
