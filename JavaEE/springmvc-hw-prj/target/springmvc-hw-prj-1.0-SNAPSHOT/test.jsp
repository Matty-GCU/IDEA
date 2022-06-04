<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
    字符串"abc"是否contains字符串"b"？
    ${fn:contains("abc", "b")}<br>
    字符串"abc"是否contains字符串"b"？
    ${fn:contains("abc", "B")}<br>
    字符串"abc"是否contains(Ignore Case)字符串"B"？
    ${fn:containsIgnoreCase("abc", "B")}<br>
    字符串"abc"是否startWith字符串"a"？
    ${fn:startsWith("abc", "a")}<br>
    字符串"abc"是否startWith字符串"b"？
    ${fn:startsWith("abc", "b")}<br>
    <hr>
    ${fn:substring("abcd", 1, 3)}<br>
    ${fn:substringBefore("abcd", "c")}<br>
    ${fn:substringAfter("abcd", "b")}<br>

</body>
</html>
