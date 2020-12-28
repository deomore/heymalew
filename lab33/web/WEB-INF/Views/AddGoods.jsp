<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: deom
  Date: 27.12.2020
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
</head>
<body>
<h1>Add new Goods</h1>
<form method="post" action="${pageContext.request.contextPath}/goods/addNew">
    <p>
        <label>Mark: </label>
        <input type="text" name="Manuf">
    </p>
    <p>
        <label>Model: </label>
        <input type="text" name="Cat">
    </p>
    <p>
        <label>Weight: </label>
        <input type="text" name="Price">
    </p>

</form>
</body>
</html>
