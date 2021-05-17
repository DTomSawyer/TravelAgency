<%--
  Created by IntelliJ IDEA.
  User: kwint
  Date: 16.05.2021
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>

<h2>Orders of ${user.email}</h2>
<table border="1">
    <thead>
    <tr>
        <th>Order Id</th>
        <th>Hotel</th>
        <th>Room</th>
        <th>Arrival Date</th>
        <th>Departure Date</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${user.orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.hotel}</td>
            <td>${order.room.type}</td>
            <td>${order.arrivalDate}</td>
            <td>${order.departureDate}</td>
            <td>${order.room.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
