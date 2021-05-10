<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 5/5/21
  Time: 8:10 пп
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>All Users</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Country</th>
        <th>City</th>
        <th>Name</th>
    </tr>
    <c:forEach var="hotel" items="${hotels}">
        <tr>
            <td>${hotel.id}</td>
            <td>${hotel.country}</td>
            <td>${hotel.city}</td>
            <td>${hotel.name}</td>
        </tr>

    </c:forEach>

    </tr>
    <td><input type="submit" value="Submit" /></td>
    </tr>
</table>
</body>
</html>
