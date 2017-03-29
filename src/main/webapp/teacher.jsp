<%--
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
<script type="text/javascript">
    function ok() {
        var jsppage = "/CreateExam.jsp";

    }

</script>
<body>
        欢迎教师XXX
        <div id="container">
            <div class="box1">
                <a href="/CreateExam.jsp"><input type="button" value="创建试卷" onclick="ok()"/></a>

            </div>
            <div class="box2">
                <iframe src="/CreateExam.jsp" width="685" height="700" ></iframe>
            </div>
        </div>

</body>
</html>
