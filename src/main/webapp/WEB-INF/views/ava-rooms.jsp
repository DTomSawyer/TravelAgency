<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Filter</title>
</head>
<body>
<table border="1">
    <thead>
    <h3>Book your room</h3>

    <a>Available rooms in ${country} between</a>
    <input name="arrivalDate" value="${arrivalDate}" readonly/>
    <a>and</a>
    <input name="arrivalDate" value="${departureDate}" readonly/>
    <br/>
    <a href="/home">Change Dates</a>

    <tr>
        <th>Id</th>
        <th>Hotel</th>
        <th>City</th>
        <th>Type</th>
        <th>Price</th>
        <th>Number</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="room" items="${available}">

        <c:url var="bookLink" value="/home/book">
            <c:param name="roomId" value="${room.id}"/>
            <c:param name="arrivalDate" value="${arrivalDate}"/>
            <c:param name="departureDate" value="${departureDate}"/>
        </c:url>

        <sf:form method="post" action="${bookLink}">
            <tr>
            <td>${room.id}</td>
            <td>${room.hotel.name}</td>
            <td>${room.hotel.city}</td>
            <td>${room.type}</td>
            <td>${room.price}</td>
            <td>${room.number}</td>
            <td>
                <button type="submit">Book</button>
            </td>
            </tr>
        </sf:form>

    </c:forEach>
    </tbody>
</table>
</body>
</html>