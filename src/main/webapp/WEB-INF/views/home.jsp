<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome ${username}</h1>
<form action="filter">
    <input type="text" name="country">
    <input type="submit" value="Submit" />
</form>
<h3>List</h3>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Country</th>
        <th>AvailableRooms</th>
        <th>Rooms</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hotels" items="${hotels}">
<%--        <c:url var="bookLink" value="/hotel/addOrder">--%>
<%--            <c:param name="hotelId" value="${hotels.id}"/>--%>
<%--        </c:url>--%>
        <tr>
            <td>${hotels.id}</td>
            <td>${hotels.city}</td>
            <td>${hotels.country}</td>

<%--            <td>--%>
<%--                <a href="${bookLink}">Make book<a/>--%>

<%--            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/hotel/management">Management</a>
</body>
</html>

