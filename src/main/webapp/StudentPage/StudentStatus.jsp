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
    <title>学习状态查询</title>
    <script src="../js/jquery-1.11.0.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("#majorid").change(function () {
                var major = "";
                $("#majorid option").each(function () {
                    if(this.selected){
                        major = this.value;
                    }
                });
                $.ajax({
                    data:"majorid="+major,
                    dataType:"text json",
                    url:"/subject",
                    type:"post",
                    success:function (txt) {
                        $("#subjectid option").remove();
                        var option ="<option value='999'>请认真选择</option>";

                        $("#subjectid").append(option);
                        $(txt).each(function (i) {
                            option ="<option value='"+txt[i].subjectId +"'>"+txt[i].subjectName+"</option>"
                            $("#subjectid").append(option);
                        });
                    }
                });
            });
        });
    </script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                data:"",
                dataType:"text json",
                url:"/major",
                type:"post",
                success:function (txt) {
                    $("#majorid option").remove();
                    var option ="<option value='999'>请认真选择</option>";
                    $("#majorid").append(option);
                    $(txt).each(function (i) {
                        option ="<option value='"+txt[i].majorId +"'>"+txt[i].majorName+"</option>"
                        $("#majorid").append(option);
                    });
                }
            });
        });
    </script>
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
        <h2>学习状态查询</h2>
        <form id = "form1" action="/studentstatus" method="post" name="studentstatus">
            专业：<select id="majorid" name="major">
            <option value="999">请认真选择</option>
            </select>
            科目：<select id="subjectid" name="subject">
            <option value="999">请认真选择</option>
            </select><br/>
            你的学号:<br/><input type="text" id="stuid" name="stuid" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /><br/>
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
        var n = document.getElementById("majorid");
        var i = document.getElementById("subjectid");
        var z = document.getElementById("stuid");
        if(n.value.length<0 || n.value =="999"){
            alert("请选择专业！");
            return;
        }
        if(i.value.length<0 || i.value =="999"){
            alert("请选择科目！");
            return;
        }
        if(z.value.length<0 || z.value ==""){
            alert("请输入你的学号！");
            return;
        }
        document.all.studentstatus.submit();
    }
</script>
</html>
