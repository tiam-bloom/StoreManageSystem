<%--
  Created by IntelliJ IDEA.
  User: 30362
  Date: 2021/6/2
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
    <title>商品进货单</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                        <li>
                            <a href="/SearchServlet">Bill</a>
                        </li>
                        <li class="active">
                            <a>Purchase list</a>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search" action="SearchPL" method="get">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search" name="name"/>
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
                                    <a href="#">注销</a>
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
                        商品编号
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        商品数量
                    </th>
                    <th>
                        进货单价
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
                <c:forEach var="pl" items="${sessionScope.PL}">
                    <tr>
                        <td>${pl.id}</td>
                        <td>${pl.name}</td>
                        <td>${pl.amount}</td>
                        <td>${pl.priceIn}</td>
                        <td>${pl.amountPrice}</td>
                        <td><a href="/deletePL?id=${pl.id}">删除</a>|
                            <a href="#Model_update" data-toggle="modal"
                               onclick="updatePL('${pl.id}','${pl.name}','${pl.amount}','${pl.priceIn}','${pl.amountPrice}')">修改</a>
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
                <h4 class="modal-title" id="myModalLabel_add">
                    添加表单
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="/addPL" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品编号</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">商品编号由系统自动生成</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">商品名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入商品名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="amount" class="col-sm-2 control-label">商品数量</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="amount" name="amount" placeholder="请输入商品数量">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="priceIn" class="col-sm-2 control-label">进货单价</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="priceIn" name="priceIn"
                                   placeholder="请输入进货单价">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="amountPrice" class="col-sm-2 control-label">商品总额</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="amountPrice" name="amountPrice"
                                   placeholder="请输入商品总额">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消
                        </button>
                        <button type="submit" class="btn btn-primary">
                            确定添加
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
                <h4 class="modal-title" id="myModalLabel_up">
                    修改表单
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="/updatePL" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品编号</label>
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
                        <label for="amount_up" class="col-sm-2 control-label">商品数量</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="amount_up" name="amount"
                                   placeholder="请输入商品数量">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="priceIn_up" class="col-sm-2 control-label">进货单价</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="priceIn_up" name="priceIn"
                                   placeholder="请输入进货单价">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="amountPrice_up" class="col-sm-2 control-label">商品总额</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="amountPrice_up" name="amountPrice"
                                   placeholder="请输入商品总额">
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
    function updatePL(id, name, amount, priceIn, amountPrice) {
        id_up.value = id;
        name_up.value = name;
        amount_up.value = amount;
        priceIn_up.value = priceIn;
        amountPrice_up.value = amountPrice
    }
</script>
</body>
</html>
