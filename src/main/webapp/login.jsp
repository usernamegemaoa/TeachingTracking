<%--
  Created by IntelliJ IDEA.
  User: Neko
  Date: 2017/3/27
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教学质量跟踪系统</title>
</head>
<style> body{background-color:#C0C0C0} </style>
<body>
<div style="left: 530px; position: absolute; top: 125px;">
    <img src="/material/head_bg.jpg" /></div><!--Title图片-->

<div style="left: 650px; position: absolute; top: 250px;">
    <h2>教学质量跟踪系统</h2>
<form id = "form1" action="login" method="post" name="login">
    用户名<input type="text" id="name" name="name"/><br/>
    密码<input type="text" id="pwd" name="pwd"/><br/>
    <select name="log">
        <option value="0">学生</option>
        <option value="1">教师/管理员</option>
    </select>
    <input type="button" value="登录" onclick="ok()"><br/>
</form>
</div>


<script type="text/javascript" charset="utf-8">
    function ok() {
        var n = document.getElementById("name");
        var i = document.getElementById("pwd");
        if(n.value.length<0 || n.value ==""){
            alert("用户名不能为空！");
            return;
        }
        document.all.login.submit();
    }
</script>

</body>
</html>
