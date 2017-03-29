<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/29
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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

        <h2>教师信息注册</h2>
        <form id = "form1" action="/createsubject" method="post" name="subject">
            姓名:<br/><input type="text" id="name" name="teaname"/><br/>
            性别:<br/><input type="text" id="sex" name="teasex"/><br/>
            所属专业:<br/><select id="majorid" name="majorid">
                        <option value="999">
                        请认真选择
                        </option>
                        </select><br/>
            密码:<br/><input type="password" id="pwd" name="teapwd"/><br/>
            <input type="button" value="提交" onclick="ok()"><br/>
            </form>
    </div>
</div>
</body>
</html>
