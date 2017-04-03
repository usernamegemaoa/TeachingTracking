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
                    url:"/classid",
                    type:"post",
                    success:function (txt) {
                        $("#classid option").remove();
                        var option ="<option value='999'>请认真选择</option>";

                        $("#classid").append(option);
                        $(txt).each(function (i) {
                            //alert(option);
                            option ="<option value='"+txt[i].classId +"'>"+txt[i].classNum+"</option>"
                            $("#classid").append(option);
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
管理员页面
<div id="container">
    <div class="box1">
        <a href="/AdminPage/CreateMajor.jsp"><input type="button" value="创建专业"/></a><br/><br/>
        <a href="/AdminPage/CreateSubject.jsp"><input type="button" value="创建科目"/></a><br/><br/>
        <a href="/AdminPage/CreateStudent.jsp"><input type="button" value="学生信息注册"/></a><br/><br/>
        <a href="/AdminPage/CreateTeacher.jsp"><input type="button" value="教师信息注册"/></a><br/><br/>
        <a href="../admin.jsp"><input type="button" value="返回主页"/></a><br>
    </div>
    <div class="box2">
        <h2>学生信息注册</h2>
        <form id = "form1" action="/createstudent" method="post" name="student">
            姓名:<br/><input type="text" id="name" name="stuname"/><br/>
            性别:<br/><input type="text" id="sex" name="stusex"/><br/>
            出生日期:<br/><input type="text" id="date" name="studate"/><br/>
            所属专业:<br/><select id="majorid" name="majorid">
                    <option value="999">
                    请认真选择
                    </option>
                    </select><br/>
            班级:<br/><select id="classid" name="classid">
                    <option value="999">
                    请认真选择
                    </option>
                    </select><br/>
            入学年份:<br/><input type="text" id="inyear" name="stuinyear"/><br/>
            密码:<br/><input type="password" id="pwd" name="stupwd"/><br/>
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
        var i = document.getElementById("sex");
        var d = document.getElementById("date");
        var y = document.getElementById("majorid");
        var c = document.getElementById("classid");
        var a = document.getElementById("inyear");
        var t = document.getElementById("pwd");
        if(n.value.length<0 || n.value ==""){
            alert("姓名不能为空！");
            return;
        }
        if(i.value.length<0 || i.value ==""){
            alert("性别不能为空！");
            return;
        }if(i.value.length<0 || i.value ==""){
            alert("性别不能为空！");
            return;
        }
        if(d.value.length<0 || d.value ==""){
            alert("出生日期不能为空！");
            return;
        }
        if(y.value.length<0 || y.value ==""){
            alert("请选择所属专业！");
            return;
        }
        if(c.value.length<0 || c.value ==""){
            alert("请选择所属班级！");
            return;
        }
        if(a.value.length<0 || a.value ==""){
            alert("入学年份不能为空！");
            return;
        }
        if(t.value.length<0 || t.value ==""){
            alert("密码不能为空！");
            return;
        }
        document.all.student.submit();
    }
</script>
</html>
