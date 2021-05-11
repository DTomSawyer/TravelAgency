<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form  action="booking" method="post">
    <html>
    <head>
        <title>Filter</title>
    </head>
    <body>
    <table border="1">
        <thead>
        <tr>
            <th>Id</th>
            <th>Number</th>
            <th>Hotel</th>
            <th>Type</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${available}">
            <c:url var="bookLink" value="/booking">
                <c:param name="room" value="${room}"/>
<%--                roomId ? --%>
            </c:url>
            <tr>
                <td>${room.id}</td>
                <td>${room.number}</td>
                <td>${room.hotel}</td>
                <td>${room.type}</td>
                <td>${room.price}</td>
                <td>
                    <a href="${bookLink}">Make book<a/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/home">Change Dates</a>
    </body>
    </html>
</form:form>