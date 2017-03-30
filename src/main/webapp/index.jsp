<%@page contentType="text/html; charset=utf-8" language="java" %>

<!--meta http-equiv="content-type" content="text/html; charset=utf-8" /-->
<%--@taglib prefix="c" url="http://java.sun.com/jsp/jstl/core"--%>
<html>
<body>
<h2>学校专业添加</h2>


<form id = "form1" action="major" method="post" name="createmajor">
    专业名称<input type="text" id="name" name="majorname"/><br/>
    专业简介<input type="text" id="intro" name="majorintro"/><br/>
    <input type="button" value="提交" onclick="ok()"><br/>
</form>

<a href="/TeacherPage/CreateExam.jsp"><input type="button" value="创建试卷"/></a>
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

<script type="text/javascript" charset="utf-8">
    function ok() {
        var n = document.getElementById("name");
        var i = document.getElementById("intro");
        if(n.value.length<0 || n.value ==""){
            alert("专业名称不能为空！");
            return;
        }
        document.all.createmajor.submit();
    }
</script>


</body>
</html>
