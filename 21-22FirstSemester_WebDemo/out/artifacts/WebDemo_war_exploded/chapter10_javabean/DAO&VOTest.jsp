<%@ page import="chapter10.javabean.StudentVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chapter10.javabean.StudentDAO" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Matty's PC
  Date: 2021/11/30
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在jsp中使用DAO和VO</title>
</head>
<body>
    <table rules="all" frame="border">
        <tr>
            <td>学号</td>
            <td>姓名</td>
        </tr>
        <%
            ArrayList<StudentVO> stus = null;
            try {
                stus = StudentDAO.queryAllStudents();
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
            for(StudentVO stu: stus) {
        %>
        <tr>
            <td><%=stu.getId()%></td>
            <td><%=stu.getName()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
