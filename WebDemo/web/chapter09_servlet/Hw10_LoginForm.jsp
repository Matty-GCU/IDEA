<%--
  Created by IntelliJ IDEA.
  User: Matty's PC
  Date: 2021/11/17
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>作业10用户登录页面</title>
</head>
<body>
<form action="/WebDemo/Hw10/ControllerServlet" method="post">
    message: <%=request.getAttribute("message")%><br>
    用户登录：<br>
    <input type="text" name="userName"><br>
    <input type="text" name="userPassword"><br>
    <input type="submit" value="登录">
    <div>
        作业10作业要求：<br>
        JSP、Servlet、Filter的使用。<br>
        在JSP页面中设置表单，输入用户名和密码提交给一个Servlet，<br>
        在Servlet中判断用户名密码是否相符，若相符，把用户名保存在session中，重定向到欢迎JSP页面，从session中提取用户名显示；<br>
        若不相符，把“用户名或密码错误”字符串保存在request对象中，转向到登录页面。<br>
        设置过滤器Filter，对欢迎页面进行过滤，处理中文乱码问题，并检查session中是否有用户名，若没有，则重定向到登录页面。<br>
        （把展开的项目结构截图、JSP文件、Servlet和Filter源代码文件、web.xml配置文件作为附件上传，各个运行结果界面截图贴到答案框）<br>
    </div>
</form>
</body>
</html>
