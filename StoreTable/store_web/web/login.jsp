<%--
  Created by IntelliJ IDEA.
  User: 30362
  Date: 2021/6/18
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
    <script src="../js/jquery-1.10.1.js"></script>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script>
        function check() {
            var username = $("#username").val();
            var psw = $("#psw").val();
            if (username =="" || psw == ""){
                $("#message").text("账号或密码不能为空！");
                return false;
            }
            return true;
        };
        $(document).ready(function () {
            $(".form-control").focus(function(){
                $("#message").text("");
            });
            $("button[type='reset']").click(function () {
                $("#message").text("");
            })
        })
    </script>
    <style>
        .container{
            display:table;
            height:100%;
        }
        .row{
            display: table-cell;
            vertical-align: middle;
        }
        .row-centered {
            text-align:center;
        }
        .col-centered {
            display:inline-block;
            float:none;
            text-align:left;
            margin-right:-4px;
        }
        h1{
            position: absolute;
            top: 40px;
            left: 200px;
        }
        body{
            background-image: url(img/pexels-lukas-669610.jpg);
            background-size: cover;;
        }
        #cookie{
            float: right;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>财务管理系统</h1>
    <div class="row row-centered">
        <div class="well col-md-4 col-centered">
            <h2>欢迎登录</h2>
            <form action="/loginServlet" method="post" role="form" onsubmit="return check()">
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" value="${sessionScope.Users.username}" />
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon2"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" id="psw" name="psw" placeholder="请输入密码" value="${sessionScope.Users.psw}"/>
                </div>
                <div id="cookie">
                    <div class="col-md-1">
                        <input type="checkbox" id="autologin" name="autologin" value="${60*60*24}"/>
                    </div>
                    <label class="control-label" for="autologin">记住我</label>
                </div>
                <font color="red"><span id="message">${sessionScope.msg}</span></font>
                <br/>
                <button type="submit" class="btn btn-success btn-block">登录</button>
                <button type="reset" class="btn btn-danger btn-block">重置</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
