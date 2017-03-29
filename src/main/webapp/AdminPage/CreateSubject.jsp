<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/29
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="jquery-1.11.0.js" type="text/javascript"></script>
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
管理员XXX
<div id="container">
    <div class="box1">
        <a href="/AdminPage/CreateMajor.jsp"><input type="button" value="创建专业"/></a><br/><br/>
        <a href="/AdminPage/CreateSubject.jsp"><input type="button" value="创建科目"/></a><br/><br/>
        <a href="/AdminPage/CreateStudent.jsp"><input type="button" value="学生信息注册"/></a><br/><br/>
        <a href="/AdminPage/CreateTeacher.jsp"><input type="button" value="教师信息注册"/></a><br/>
    </div>
    <div class="box2">
        <h2>创建科目</h2>
        <form id = "form1" action="/subject" method="post" name="subject">
            科目名称:<br/><input type="text" id="name" name="subjectname"/><br/>
            所属专业:<br/><select id="majorid">
                    <option value="999">
                     请认真选择
                    </option>
                    </select><br/>
            授课学年:<br/><input type="text" id="year" name="subjectyear"/><br/>
            课时次数:<br/><input type="text" id="times" name="subjecttimes"/><br/>
            科目简介:<br/><textarea id="intro" name="subjectintro" style="width:200px;height:80px;">这里写内容</textarea><br/>
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
        var n = document.getElementById("name");
        var i = document.getElementById("majorid");
        var y = document.getElementById("year");
        var t = document.getElementById("times");
        var o = document.getElementById("intro");
        if(n.value.length<0 || n.value ==""){
            alert("科目名不能为空！");
            return;
        }
        if(y.value.length<0 || y.value ==""){
            alert("科目名不能为空！");
            return;
        }
        if(t.value.length<0 || t.value ==""){
            alert("科目名不能为空！");
            return;
        }
        document.all.subject.submit();
    }
</script>
</html>
