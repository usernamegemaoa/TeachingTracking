<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/30
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
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
            $("#subjectid").change(function () {
                var subjectid = "";
                $("#subjectid option").each(function () {
                    if(this.selected){
                        subjectid = this.value;
                    }
                });
                $.ajax({
                    data:"subjectid="+subjectid,
                    dataType:"text json",
                    url:"/lesson",
                    type:"post",
                    success:function (txt) {
                        $("#lessonnum option").remove();
                        var option ="<option value='999'>请认真选择</option>";

                        $("#lessonnum").append(option);
                        $(txt).each(function (i) {
                            option ="<option value='"+txt[i].lessonNum +"'>"+txt[i].lessonNum+"</option>"
                            $("#lessonnum").append(option);
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
你好，教师：${sessionScope.user==null?"null":sessionScope.user.teaName}<br>
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
        <h2>查看反馈页面</h2>
        <form id = "form1" action="/showfeedback" method="post" name="showfeedback">
            专业：<select id="majorid" name="major">
            <option value="999">请认真选择</option>
            </select><br/>
            科目：<select id="subjectid" name="subject">
            <option value="999">请认真选择</option>
            </select><br/>
            课时：<select id="lessonnum" name="lesson">
            <option value="999">请认真选择</option>
            </select><br/>
            <input type="button" value="查询" onclick="ok()"><br/>
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
        var t = document.getElementById("subjectid");
        var a = document.getElementById("lessonnum");
        if(n.value.length<0 || n.value =="999"){
            alert("请选择专业！");
            return;
        }
        if(t.value.length<0 || t.value =="999"){
            alert("请选择科目！");
            return;
        }
        if(a.value.length<0 || a.value =="999"){
            alert("请选择课时！");
            return;
        }
        document.all.showfeedback.submit();
    }
</script>

</body>
</html>
