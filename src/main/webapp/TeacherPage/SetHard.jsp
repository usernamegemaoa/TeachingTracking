<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/22
  Time: 0:31
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
        <h2>难度设定页面</h2>
        <form id = "form1" action="/sethard" method="post" name="sethard">
            专业：<select id="majorid" name="major">
            <option value="999">请认真选择</option>
            </select>
            科目：<select id="subjectid" name="subject">
            <option value="999">请认真选择</option>
            </select><br/>
            试卷年份：<br/><input type="text" id="examtime" name="examtime"/><br/>
            AB卷：<br/><input type="text" id="examab" name="examab"/><br/>
            试卷题号：<br/><input type="text" id="questionexam" name="questionexam" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            难度：(以10分满计算)<br/><input type="text" id="hard" name="questionhard" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
            分值：<br/><input type="text" id="mark" name="questionmark" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br/>
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
<script type="text/javascript" charset="utf-8">
    function ok() {
        var m = document.getElementById("majorid");
        var s = document.getElementById("subjectid");
        var e = document.getElementById("examtime");
        var a = document.getElementById("examab");
        var q = document.getElementById("questionexam");
        var h = document.getElementById("hard");
        var k = document.getElementById("mark");
        if(m.value.length<0 || m.value =="999"){
            alert("请选择专业！");
            return;
        }
        if(s.value.length<0 || s.value =="999"){
            alert("请选择科目！");
            return;
        }
        if(e.value.length<0 || e.value ==""){
            alert("请输入试卷年份！");
            return;
        }
        if(a.value !="" &&a.value !="a" &&a.value !="A" &&a.value !="b"&&a.value !="B"){
            alert("请输入ab卷或格式输入不正确！");
            return;
        }
        if(q.value.length<0 || q.value ==""){
            alert("请输入题号");
            return;
        }
        if(h.value.length<0 || h.value ==""){
            alert("请设定难度(ABCD对应1，2，3，4)");
            return;
        }
        if(k.value.length<0 || k.value ==""){
            alert("请输入该题目分值");
            return;
        }

        document.all.sethard.submit();
    }
</script>
</body>
</html>
