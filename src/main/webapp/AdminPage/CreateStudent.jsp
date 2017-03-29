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
        <h2>学生信息注册</h2>
        <form id = "form1" action="/createstudent" method="post" name="major">
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
    </div>
</div>
</body>
</html>
