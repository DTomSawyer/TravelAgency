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
        <th>First Name</th>
        <th>Last Name</th>
        <th>Orders</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
