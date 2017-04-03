<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="java.security.acl.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/30
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<html>
<head>
    <title>查询作业</title>
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
        <h2>查询作业</h2>
        <form id = "form1" action="/searchhomework" method="post" name="searchhomework">
            专业：<select id="majorid" name="major">
                <option value="999">请认真选择</option>
            </select>
            科目：<select id="subjectid" name="subject">
                <option value="999">请认真选择</option>
            </select>
            课时：<select id="lessonnum" name="lesson">
                <option value="999">请认真选择</option>
            </select>
            <input type="button" value="查询" onclick="ok()"><br/>
        </form>
        <%
            if(request.getAttribute("success")!=null){
                out.println("<h3 class = 't1'>");
        %>
        <%  String s = request.getAttribute("success").toString();
            //将JSON字符串中的英文替换为中文
            //这段代码有问题，需要改动
            String str1 =null;
            String str2 =null;
            String str3 =null;
            String str4 =null;
            str1 = s.replaceAll("workId","作业ID");
            str2 = str1.replaceAll("subjectId","科目编号");
            str3 = str2.replaceAll("lessonId","课程编号");
            str4 = str3.replaceAll("workContent","作业内容");
            out.println(str4);
        %>
        <%
                out.println("</h3>");
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
        var m = document.getElementById("lessonnum");
        if(n.value.length<0 || n.value =="999"){
            alert("请选择专业！");
            return;
        }
        if(i.value.length<0 || i.value =="999"){
            alert("请选择科目！");
            return;
        }
        if(m.value.length<0 || m.value =="999"){
            alert("请选择课时！");
            return;
        }
        document.all.searchhomework.submit();
    }
</script>
</html>
