<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/27
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩提交页面</title>
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
欢迎教师
<div id="container">
    <div class="box1">
        <a href="../TeacherPage/CreateExam.jsp"><input type="button" value="创建试卷"/></a><br><br>
        <a href="../TeacherPage/SetHard.jsp"><input type="button" value="难度设定"/></a><br><br>
        <a href="../TeacherPage/UploadMark.jsp"><input type="button" value="成绩提交"/></a><br><br>
        <a href="../TeacherPage/AnalyzeMark.jsp"><input type="button" value="期末成绩分析"/></a><br><br>
        <a href="../TeacherPage/WorkManagement.jsp"><input type="button" value="出勤管理"/></a><br><br>
        <a href="../TeacherPage/SetHomework.jsp"><input type="button" value="布置作业"/></a><br><br>
        <a href="../TeacherPage/UploadHomework.jsp"><input type="button" value="作业成绩提交"/></a><br><br>
        <a href="../TeacherPage/AnalyzeHomework.jsp"><input type="button" value="作业情况分析"/></a><br><br>
        <a href="../TeacherPage/AnalyzeWork.jsp"><input type="button" value="出勤情况分析"/></a><br><br>
        <a href="../TeacherPage/ShowFeedback.jsp"><input type="button" value="查看反馈"/></a><br><br>
        <a href="../teacher.jsp"><input type="button" value="返回主页"/></a><br>
    </div>
    <div class="box2">
        <h2>成绩提交页面</h2>
        <form id = "form1" action="/uploadmark" method="post" name="uploadmark">
            专业：<select id="majorid" name="major">
            <option value="999">请认真选择</option>
            </select>
            科目：<select id="subjectid" name="subject">
            <option value="999">请认真选择</option>
            </select><br/>
            课时：<select id="lessonnum" name="lesson">
            <option value="999">请认真选择</option>
            </select><br/>
            试卷年份<input type="text" id="time" name="examtime"/><br/>
            AB卷<input type="text" id="ab" name="examab"/><br/>
            学号<input type="text" id="stuid" name="stuid" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            试卷有几道题就填写几处,没有题目的填入0(自动计算总分)<br/>
            小题1：<input type="text" id="mark1" name="mark1" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题2：<input type="text" id="mark2" name="mark2" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题3：<input type="text" id="mark3" name="mark3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题4：<input type="text" id="mark4" name="mark4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题5：<input type="text" id="mark5" name="mark5" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题6：<input type="text" id="mark6" name="mark6" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题7：<input type="text" id="mark7" name="mark7" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题8：<input type="text" id="mark8" name="mark8" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题9：<input type="text" id="mark9" name="mark9" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            小题10：<input type="text" id="mark10" name="mark10" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            <input type="submit" value="提交分数" onclick="ok()"><br/>
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
<script type="text/javascript" charset="utf-8">
    function ok() {
        var n = document.getElementById("majorid");
        var d = document.getElementById("subjectid");
        var t = document.getElementById("time");
        var a = document.getElementById("ab");
        var k = document.getElementById("stuid");
        var m1 = document.getElementById("mark1");
        var m2 = document.getElementById("mark2");
        var m3 = document.getElementById("mark3");
        var m4 = document.getElementById("mark4");
        var m5 = document.getElementById("mark5");
        var m6 = document.getElementById("mark6");
        var m7 = document.getElementById("mark7");
        var m8 = document.getElementById("mark8");
        var m9 = document.getElementById("mark9");
        var m10 = document.getElementById("mark10");
        if(n.value.length<0 || n.value =="999"){
            alert("请选择专业！");
            return;
        }
        if(d.value.length<0 || d.value =="999"){
            alert("请选择科目！");
            return;
        }
        if(t.value.length<0 || t.value ==""){
            alert("请输入试卷年份！");
            return;
        }
        if(a.value !="" &&a.value !="a" &&a.value !="A" &&a.value !="b"&&a.value !="B"){
            alert("请输入ab卷或格式输入不正确！");
            return;
        }
        if(d.value.length<0 || d.value ==""){
            alert("请输入学号！");
            return;
        }
        document.all.uploadmark.submit();
    }
</script>
</body>
</html>
