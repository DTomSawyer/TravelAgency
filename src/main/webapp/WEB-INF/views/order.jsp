<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/resources/css/order.css"%></style>
<html>
<head>
    <title>Order #${order.id}</title>
</head>
<body>

<h2>Your order #${order.id} has been saved</h2>
<p>${order.hotel.country}, ${order.hotel.city}</p>
<p>${order.hotel.name}, ${order.room.type} room, ${order.room.price}$</p>
<p>${order.arrivalDate} - ${order.departureDate}</p>

</body>
</html>
