<%--
  Created by IntelliJ IDEA.
  User: 30362
  Date: 2021/6/17
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>账单记录</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            var td = $("td").text();
            if (td==null||td==""||td==undefined){
                alert("查询不到相关用户名或商品名！");
                location.href="/SearchServlet"
            }
        })
    </script>
    <style>
        .form-control-static{
            color: lightslategray;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <!-- 导航栏 -->
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand">JV财务管理系统</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a>Bill</a>
                        </li>
                        <li>
                            <a href="/SearchPL">Purchase list</a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search" action="/SearchServlet" method="get">
                        <div class="form-group">
                            <input name="name" type="text" class="form-control" placeholder="Search"/>
                        </div>
                        <button type="submit" class="btn btn-default">查询</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">欢迎你:${Users.username}</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心<strong
                                    class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="/logoutServlet">注销</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <!-- 主体部分表单 -->
    <div class="row clearfix">
        <div class="col-md-2 column"></div>
        <div class="col-md-8 column">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
                        订单编号
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        客户姓名
                    </th>
                    <th>
                        下单数量
                    </th>
                    <th>
                        成交时间
                    </th>
                    <th>
                        商品总额
                    </th>
                    <th>
                        操作|<a href="#Modal_add" data-toggle="modal">添加</a>
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bill" items="${sessionScope.bills}">
                    <tr>
                        <td>${bill.id}</td>
                        <td>${bill.name}</td>
                        <td>${bill.cname}</td>
                        <td>${bill.amountb}</td>
                        <td>${bill.time}</td>
                        <td>${bill.price}</td>
                        <td>
                            <a href="/deleteBill?id=${bill.id}">删除</a>|
                            <a href="#Model_update" data-toggle="modal"
                               onclick="updateBill('${bill.id}','${bill.name}','${bill.cname}','${bill.amountb}','${bill.time}','${bill.price}')">修改</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-2 column"></div>
    </div>
</div>
<!-- 模态框——添加（Modal） -->
<div class="modal fade" id="Modal_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModal_add">
                    添加表单
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="/addBill" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">订单编号</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">订单编号由系统自动生成</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">商品名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入商品名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cname" class="col-sm-2 control-label">客户姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cname" name="cname" placeholder="请输入客户姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="amountb" class="col-sm-2 control-label">下单数量</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="amountb" name="amountb" placeholder="请输入下单数量">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="time" class="col-sm-2 control-label">成交时间</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="time" name="time"
                                   placeholder="请输入成交时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-sm-2 control-label">商品总额</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="price" name="price" placeholder="请输入商品总额">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消
                        </button>
                        <button type="submit" class="btn btn-primary">
                            添加
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 修改——模态框 -->
<div class="modal fade" id="Model_update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModal_update">
                    修改表单
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="/updateBill" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">订单编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="id_up" name="id" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name_up" class="col-sm-2 control-label">商品名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name_up" name="name" placeholder="请输入商品名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cname_up" class="col-sm-2 control-label">客户姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cname_up" name="cname" placeholder="请输入客户姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="amountb_up" class="col-sm-2 control-label">下单数量</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="amountb_up" name="amountb"
                                   placeholder="请输入下单数量">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="time_up" class="col-sm-2 control-label">成交时间</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" id="time_up" name="time"
                                   placeholder="请输入成交时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price_up" class="col-sm-2 control-label">商品总额</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="price_up" name="price" placeholder="请输入商品总额">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消
                        </button>
                        <button type="submit" class="btn btn-primary">
                            确定修改
                        </button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

<script>
    function updateBill(id, name, cname, amountb, time, price) {
        id_up.value = id;
        name_up.value = name;
        cname_up.value = cname;
        amountb_up.value = amountb;
        time_up.value = time;
        price_up.value = price;
    }
</script>

</body>
</html>
