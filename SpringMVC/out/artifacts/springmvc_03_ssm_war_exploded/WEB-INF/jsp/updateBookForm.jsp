<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">修改书籍</h1>
        </div>
    </div>
    <%-- https://v4.bootcss.com/docs/components/forms/ --%>
    <form class="form" action="${pageContext.request.contextPath}/books/update" method="post">
        <div class="form-group">
            <label>编号</label>
            <%-- https://v4.bootcss.com/docs/components/forms/#readonly --%>
            <input class="form-control" class="form-control" type="text" name="id" value="${param.id}" readonly>
        </div>
        <div class="form-group">
            <label>书名</label>
            <input class="form-control" type="text" name="title" value="${book.title}"><br>
        </div>
        <div class="form-group">
            <label>数量</label>
            <input class="form-control" type="text" name="number" value="${book.getNumber()}"><br>
        </div>
        <div class="form-group">
            <label>描述</label>
            <input class="form-control" type="text" name="introduction" value="${book.getIntroduction()}">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
