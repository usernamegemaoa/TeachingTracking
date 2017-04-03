<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/30
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
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
你好，学生:${sessionScope.user==null?"null":sessionScope.user.stuName}<br>
<div id="container">
    <div class="box1">
        <a href="../StudentPage/SearchHomework.jsp"><input type="button" value="查询作业"/></a><br/><br/>
        <a href="../StudentPage/StudentStatus.jsp"><input type="button" value="学习状态查询"/></a><br/><br/>
        <a href="../StudentPage/SetValue.jsp"><input type="button" value="教师打分"/></a><br/><br/>
        <a href="../StudentPage/SetFeedback.jsp"><input type="button" value="反馈问题"/></a><br/><br/>
        <a href="../student.jsp"><input type="button" value="返回主页"/></a><br>
    </div>
    <div class="box2">
        <h2>教师评价</h2>
        <form id = "form1" action="/setvalue" method="post" name="setvalue">
            (注：每部分评分以100分计算，本评价不实名制)<br/>
            你的学号:<br/><input type="text" id="stuid" name="stuid" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/><br/>
            教师工号:<br/><input type="text" id="teaid" name="teaid" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/><br/>
            打分项1:教学准备充分，内容充实，态度严谨。<br/><input type="text" id="value1" name="value1" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            打分项2:讲课重点突出，详略得当，讲解难点深入浅出。<br/><input type="text" id="value2" name="value2" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            打分项3:富有启发性，引导学生积极思维。<br/><input type="text" id="value3" name="value3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            你还有什么意见：<br/><input type="text" id="valuecontent" name="valuecontent" /><br/>
            <input type="button" value="提交" onclick="ok()"><br/>
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
    </div>
</div>
</body>
<script type="text/javascript" charset="utf-8">
    function ok() {
        var n = document.getElementById("stuid");
        var i = document.getElementById("teaid");
        var m = document.getElementById("value1");
        var k = document.getElementById("value2");
        var j = document.getElementById("value3");
        var l = document.getElementById("valuecontent");
        if(n.value.length<0 || n.value ==""){
            alert("请输入学号！");
            return;
        }
        if(i.value.length<0 || i.value ==""){
            alert("请教师工号！");
            return;
        }
        document.all.setvalue.submit();
    }
</script>
</html>
