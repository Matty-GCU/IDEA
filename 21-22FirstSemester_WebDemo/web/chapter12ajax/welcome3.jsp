<%--
  Created by IntelliJ IDEA.
  User: Matty's PC
  Date: 2022/1/4
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <script type="text/javascript">
        function showInfo() {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open("GET", "../index.jsp", true);
            xmlHttp.onreadystatechange = function() {
                //依次输出2 3 4，即响应onreadystatechange事件的函数运行了三次（readyState从0变1的那次，程序还没跑到这里，所以没有输出1）
                // document.writeln(xmlHttp.readyState);
                if(xmlHttp.readyState == 4) {
                    infoDiv.innerHTML = xmlHttp.responseText;
                }
            }
            xmlHttp.send();
        }
    </script>
    <input type="button" value="跳转到欢迎页面" onClick="showInfo()">
    <div id="infoDiv"></div>
</body>
</html>
