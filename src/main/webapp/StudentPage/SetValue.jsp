<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/30
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师打分</title>
</head>
<style type="text/css">
    div{margin:0;padding:0}
    #container{width:900px;height:700px;border:1px solid #000000;}
    #container .box1{width:200px;height:700px;float: left;background: url("/material/BG_1.jpg");}
    #container .box2{margin-left: 15px;width:685px;height:700px;float:left;background: url("/material/BG_1.jpg");}
</style>
<body>
<h1>学生</h1>
教师打分
<div id="container">
    <div class="box1">
        <a href="/StudentPage/SearchHomework.jsp"><input type="button" value="查询作业"/></a><br/><br/>
        <a href="/StudentPage/StudentStatus.jsp"><input type="button" value="学习状态查询"/></a><br/><br/>
        <a href="/StudentPage/SetValue.jsp"><input type="button" value="教师打分"/></a><br/><br/>
        <a href="/StudentPage/SetFeedback.jsp"><input type="button" value="反馈问题"/></a><br/>
    </div>
    <div class="box2">
        <!--h2>创建专业</h2>
        <form id = "form1" action="/createmajor" method="post" name="major">
            专业名称:<br/><input type="text" id="name" name="majorname"/><br/>
            专业简介:<br/><textarea id="intro" name="majorintro" style="width:200px;height:80px;">这里写内容</textarea><br/>
            <input type="button" value="提交" onclick="ok()"><br/>
        </form-->
        <%
            if(request.getAttribute("success")!=null){
                out.println("<h1 class = 't1'>");
        %>
        <%=request.getAttribute("success").toString()%>
        <%
                out.println("</h1>");
            }
        %>
        <%
            if(request.getAttribute("error")!=null){
                out.println("<h1 class = 't1'>");
        %>
        <%=request.getAttribute("error").toString()%>
        <%
                out.println("</h1>");
            }
        %>
    </div>
</div>
</body>
</html>
