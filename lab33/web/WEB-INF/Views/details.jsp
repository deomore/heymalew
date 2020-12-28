<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Details</title>
</head>
<body>
<h1>Goods information</h1>
<ul>
    <li>
        <label>Id: </label>
        <c:out value="${item.goodsID}"/>
    </li>
    <li>
        <label>Manuf: </label>
        <c:out value="${item.manufactor}"/>
    </li>
    <li>
        <label>Cat: </label>
        <c:out value="${item.category}"/>
    </li>
    <li>
        <label>Price: </label>
        <c:out value="${item.price}"/>
    </li>

</ul>
<a href="/laba33_war_exploded/goods/delete/${item.goodsID}">Delete Good</a>
</body>
</html>