<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍管理</title>
    <meta charset="UTF-8">
</head>
<body>
    <h3>根据书名查找书籍</h3>
    <form action="${pageContext.request.contextPath}/book/getByName" method="post">
        请输入书名：<input type="text" name="bookname">
        <input type="submit">
    </form>
    <table>

    </table>
    <hr>
    <a><button>查找所有书籍</button></a>
    <hr>
    <br><br><a><button>新增书籍</button></a>
    <hr>
    <br><br><a><button>更新书籍信息</button></a>
</body>
</html>
