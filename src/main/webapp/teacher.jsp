<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/27
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<style type="text/css">
    div{margin:0;padding:0}
    #container{width:900px;height:700px;border:1px solid #000000;}
    #container .box1{width:200px;height:700px;float: left;background: url("/material/BG_1.jpg");}
    #container .box2{margin-left: 15px;width:685px;height:700px;float:left;background: url("/material/BG_1.jpg");}
</style>
<body>
        欢迎教师XXX
        <div id="container">
            <div class="box1">
                <a href="TeacherPage/CreateExam.jsp"><input type="button" value="创建试卷"/></a><br/><br/>
                <a href="TeacherPage/SetHard.jsp"><input type="button" value="难度设定"/></a><br/><br/>
                <a href="TeacherPage/UploadMark.jsp"><input type="button" value="成绩提交"/></a><br/><br/>
                <a href="TeacherPage/AnalyzeWork.jsp"><input type="button" value="期末成绩分析"/></a><br/>
                <a href="TeacherPage/WorkManagement.jsp"><input type="button" value="出勤管理"/></a><br/>
                <a href="TeacherPage/SetHomework.jsp"><input type="button" value="布置作业"/></a><br/>
                <a href="TeacherPage/UploadHomework.jsp"><input type="button" value="作业成绩提交"/></a><br/>
                <a href="TeacherPage/AnalyzeHomework.jsp"><input type="button" value="作业情况分析"/></a><br/>
                <a href="TeacherPage/AnalyzeWork.jsp"><input type="button" value="出勤情况分析"/></a><br/>
                <a href="TeacherPage/ShowFeedback.jsp"><input type="button" value="查看反馈"/></a><br/>
            </div>
            <div class="box2">
                <h1>当前时间</h1>
                <h2>
                    <%//显示当前时间
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                        out.println(df.format(new Date()));// new Date()为获取当前系统时间
                    %>
                </h2>
            </div>
        </div>

</body>
</html>
