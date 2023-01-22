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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bill.css"/>
</head>
<body>
<div id="header">
    <h1>Tim</h1>
    <div id="logout">
        欢迎你:${User.username} <span><a href="${pageContext.request.contextPath}/logout">[退出登录]</a></span>
    </div>
</div>
<div id="nav">
    <div id="search">
        <form action="${pageContext.request.contextPath}/findAllBill">
            <input type="search" placeholder="Search" >
            <input type="button" value="查询">
        </form>
    </div>
    <ul>
        <li><a href="#">bill</a></li>
        <li><a href="purchaseList.jsp">PL</a></li>
    </ul>
</div>
<div id="content">
    <div id="row">
        <h2>出售账单</h2>
        <form action="${pageContext.request.contextPath}/addBill" method="post">
            <input type="text" name="id" placeholder="请输入商品编号">
            <input type="text" name="name" placeholder="请输入商品名">
            <input type="text" name="cname" placeholder="请输入客户名">
            <input type="text" name="amountb" placeholder="请输入购买数量">
            <input type="text" name="time" placeholder="请输入购买时间">
            <input type="text" name="price" placeholder="请输入收款金额">
            <input type="submit" value="新增"/>
        </form>
        <table border="1" cellspacing="" cellpadding="5px">
            <tr>
                <th>商品编号</th>
                <th>商品名</th>
                <th>客户名</th>
                <th>购买数量</th>
                <th>购买时间</th>
                <th>收款金额</th>
                <th>操作</th>
            </tr>
            <tr>
                <td>${bill.id}</td>
                <td>${bill.name}</td>
                <td>${bill.cname}</td>
                <td>${bill.amountb}</td>
                <td>${bill.time}</td>
                <td>${bill.price}</td>
                <td>
                    <button type="button">修改</button>
                    |
                    <button type="button">删除</button>
                </td>
            </tr>
        </table>

    </div>
</div>


</body>
</html>
