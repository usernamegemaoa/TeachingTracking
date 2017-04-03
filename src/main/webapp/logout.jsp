<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/4/3
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>正在退出，请稍后......</title>
</head>
<body>
<h2>正在退出，请稍后......</h2>
<%  session.invalidate();
    response.sendRedirect("login.jsp");
%>

</body>
</html>
