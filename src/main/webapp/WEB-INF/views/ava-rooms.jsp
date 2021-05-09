<%--
  Created by IntelliJ IDEA.
  User: Orest
  Date: 09.05.2021
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="rooms" items="${getAll}">
    <tr>
        <td>${rooms.hotel}</td>
        <td>${rooms.id}</td>
        <td>${rooms.number}</td>
        <td>${rooms.orders}</td>
        <td>${rooms.toString()}</td>
    </tr>
</c:forEach>
</body>
</html>