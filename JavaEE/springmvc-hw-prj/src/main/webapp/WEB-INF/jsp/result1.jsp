<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
    <title>结果展示页面1（表格形式）</title>
    <meta charset="UTF-8">
<body>
    <a href="${pageContext.request.contextPath}/books"><button>返回</button></a>
    <table class="table">
        <tr>
            <th scope="col">编号</th>
            <th scope="col">书名</th>
            <th scope="col">价格</th>
            <th scope="col">作者</th>
            <th scope="col">数量</th>
            <th scope="col">所属书架编号</th>
            <th scope="col">所属书架类别</th>
        </tr>
        <c:forEach var="book" items="${result}">
            <tr>
                <td scope="row">${book.id}</td>
                <td scope="row">${book.name}</td>
                <td scope="row">${book.price}</td>
                <td scope="row">${book.author}</td>
                <td scope="row">${book.number}</td>
                <td scope="row">${book.bookShelf.id}</td>
                <td scope="row">${book.bookShelf.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
