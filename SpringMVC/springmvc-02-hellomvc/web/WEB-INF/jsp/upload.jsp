<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
    <%-- 基于表单的文件上传需要使用enctype属性，并将它的值设置为multipart/form-data，同时将表单的提交方式设置为post。 --%>
    <form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/file">
        <input type="file" name="myFile">
        <input type="submit">
    </form>
</body>
</html>
