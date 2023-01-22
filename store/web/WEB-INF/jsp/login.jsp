<%--
  Created by IntelliJ IDEA.
  User: 30362
  Date: 2021/6/18
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
    <script>
        function check() {
            var username = $("#username").val();
            var psw = $("#psw").val();
            if (username =="" || psw == ""){
                $("#message").text("账号或密码不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="content">
<h1>账单管理系统</h1>
<div id="form">
    <font color="red">
        <span id="message">${msg}</span>
    </font>
    <form action="${pageContext.request.contextPath}/findUser" method="post" onsubmit="return check()">
        <div class="input">
            <label>账号：</label>
            <input id="username" type="text" name="username"/>
        </div>
        <div class="input">
            <label>密码：</label>
            <input id="psw" type="password" name="psw"/>
        </div>
        <input class="btn" type="submit" value="登录" /><input class="btn" type="reset" value="重置" />
    </form>
</div>
</div>
</body>
</html>
