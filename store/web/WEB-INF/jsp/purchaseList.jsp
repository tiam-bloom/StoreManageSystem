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

</head>
<body>
<table border="1">
    <tr>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品数量</td>
        <td>进货单价</td>
        <td>总金额</td>
    </tr>
    <c:forEach var="pl" items="${purchaseLists}">
        <tr>
            <td>${pl.id}</td>
            <td>${pl.name}</td>
            <td>${pl.amount}</td>
            <td>${pl.priceIn}</td>
            <td>${pl.amountPrice}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
