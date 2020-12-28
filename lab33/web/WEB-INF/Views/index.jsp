<%--
  Created by IntelliJ IDEA.
  User: deom
  Date: 28.12.2020
  Time: 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
    <tr>
        <th>Manuf:</th>
        <th>Category:</th>
        <th>Price:</th>
    </tr>
    <c:forEach items="${list}" var="g">
        <tr>
            <td>${g.manufactor}</td>
            <td>${g.category}</td>
            <td>${g.price}</td>

            <td><a href="/lab33_war_exploded/goods/getOne/${g.goodsID}">Show details</a> </td>
            <td><a href="/lab33_war_exploded/goods/modifyForm/${g.goodsID}">Modify</a> </td>
        </tr>
    </c:forEach>
</table>
<a href="/lab33_war_exploded/goods/addNewForm">Add new</a>
</body>
</html>
