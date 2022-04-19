<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
    <%-- https://v4.bootcss.com/docs/layout/overview/ --%>
    <div class="container">

        <%-- https://v4.bootcss.com/docs/components/jumbotron/ --%>
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4">所有书籍</h1>
            </div>
        </div>

        <%-- https://v4.bootcss.com/docs/content/tables/#table-head-options --%>
        <table class="table">
            <%-- table head --%>
            <thead class="thead-dark">
                <%-- table row --%>
                <tr>
                    <%-- table header --%>
                    <th scope="col">编号</th>
                    <th scope="col">书名</th>
                    <th scope="col">数量</th>
                    <th scope="col">简介</th>
                    <th scope="col">操作</th>
                </tr>
            </thead>
            <%-- table body --%>
            <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <th scope="row">${book.getId()}</th>
                        <%-- table data --%>
                        <td>${book.getTitle()}</td>
                        <td>${book.getNumber()}</td>
                        <td>${book.getIntroduction()}</td>
                        <td>
                            <%-- https://v4.bootcss.com/docs/components/buttons/ --%>
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/toUpdateBookForm?id=${book.getId()}" role="button">修改</a>
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/books/delete?id=${book.getId()}" role="button">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a class="btn btn-info btn-lg btn-block" href="${pageContext.request.contextPath}/books/toAddBookForm">添加书籍</a>
    </div>
</body>
</html>
