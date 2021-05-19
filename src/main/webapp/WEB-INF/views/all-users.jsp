<%--
  Created by IntelliJ IDEA.
  User: kwint
  Date: 16.05.2021
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">


        <sf:form method="get" action="${ordersLink}">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>
                    <a href = "<c:url value ="/management/getOrders/${user.id}"/>">See Order</a>
                </td>
            </tr>
        </sf:form>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
