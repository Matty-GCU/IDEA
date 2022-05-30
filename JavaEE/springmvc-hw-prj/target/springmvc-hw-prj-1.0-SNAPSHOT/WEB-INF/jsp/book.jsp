<%@ taglib prefix="" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍管理</title>
    <meta charset="UTF-8">
</head>
<body>
    <h3>根据书名查找书籍</h3>
    <form action="${pageContext.request.contextPath}/books/getByName">
        请输入书名：<input type="text" name="name" placeholder="模糊查找">
        <input type="submit" value="点击查找">
    </form>
    <hr>

    <h3>查找所有书籍</h3>
    <a href="${pageContext.request.contextPath}/books/getAll"><button>点击查找</button></a>
    <hr>

    <h3>新增书籍</h3>
    <form action="${pageContext.request.contextPath}/books/add">
        请输入书名：<input type="text" name="name"><br>
        请输入价格：<input type="text" name="price"><br>
        请输入作者：<input type="text" name="author"><br>
        请输入数量：<input type="text" name="number"><br>
        书架编号是：<input type="text" name="bookShelfId"><br>
        书架类别是：<input type="text" name="bookShelfName"><br>
        <input type="submit" value="点击添加">
    </form>
    <hr>

    <h3>更新书籍</h3>
    <form action="${pageContext.request.contextPath}/books/update">
        请输入书ID：<input type="text" path="id"/><br>
        请输入书名：<input type="text" path="name"/><br>
        请输入价格：<input type="text" path="price"/><br>
        请输入作者：<input type="text" path="author"/><br>
        请输入数量：<input type="text" path="number"/><br>
        <input type="submit" value="点击修改">
    </form>
    <hr>

    <h3>删除书籍</h3>
    <form action="${pageContext.request.contextPath}/books/delete">
        请输入书ID：<input name="id"><br>
        <input type="submit" value="点击删除"/>
    </form>
</body>
</html>