<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/27
  Time: 22:26
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
        管理员页面XXX
        <div id="container">
            <div class="box1">
                <a href="/AdminPage/CreateMajor.jsp"><input type="button" value="创建专业" onclick="ok()"/></a><br/><br/>
                <a href="/AdminPage/CreateSubject.jsp"><input type="button" value="创建科目" onclick="ok()"/></a><br/><br/>
                <a href="/AdminPage/CreateStudent.jsp"><input type="button" value="学生信息注册" onclick="ok()"/></a><br/><br/>
                <a href="/AdminPage/CreateTeacher.jsp"><input type="button" value="教师信息注册" onclick="ok()"/></a><br/>
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
