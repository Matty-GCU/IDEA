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
    <title>使用AJAX技术的跳转效果（IE6+专用）</title>
</head>
<body>
    <script type="text/javascript">
        function showInfo() {
            var xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            xmlHttp.open("GET", "../index.jsp", true);
            xmlHttp.onreadystatechange = function() {
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
