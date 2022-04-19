<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <meta charset="UTF-8">
    <!-- Bootstrap 的 CSS 文件 -->
    <%-- https://v4.bootcss.com/docs/getting-started/introduction/ --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  </head>
  <body>
    <%-- https://v4.bootcss.com/docs/components/buttons/ --%>
    <a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/books">查询所有书籍</a>
  </body>
</html>
