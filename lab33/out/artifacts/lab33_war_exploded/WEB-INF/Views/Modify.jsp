<%--
  Created by IntelliJ IDEA.
  User: deom
  Date: 28.12.2020
  Time: 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify car</title>
</head>
<body>
<h1>Modify car</h1>
<form method="post" action="${pageContext.request.contextPath}/goods/modify">
    <p>
        <label>Manuf: </label>
        <input type="text" name="manufactor" value="${item.manufactor}">
    </p>
    <p>
        <label>Cat: </label>
        <input type="text" name="model" value="${item.model}">
    </p>
    <p>
        <label>Price: </label>
        <input type="text" name="weight" value="${item.weight}">
    </p>
    <p>
        <input type="hidden" name="id" value="${item.id}">
        <input type="submit" value="Update">
    </p>
</form>
</body>
</html>
