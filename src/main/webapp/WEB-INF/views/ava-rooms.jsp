<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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