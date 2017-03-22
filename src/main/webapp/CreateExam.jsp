<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/21
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
创建试卷页面
<form id = "form1" action="createexam" method="post" name="createexam">
    科目编号<input type="text" id="id" name="subjectid"/><br/>
    试卷年份<input type="text" id="time" name="examtime"/><br/>
    AB卷<input type="text" id="ab" name="examab"/><br/>
    题目数量<input type="text" id="num" name="examnum"/><br/>
    试题总分<input type="text" id="mark" name="exammark"/><br/>
    <input type="submit" value="提交" onclick="ok()"><br/>
</form>
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
<!--script type="text/javascript" charset="utf-8">
    function ok() {
        var n = document.getElementById("id");
        var i = document.getElementById("time");
        if(n.value.length<0 || n.value ==""){
            alert("专业名称不能为空！");
            return;
        }
        document.all.createmajor.submit();
    }
</script-->
</body>
</html>
