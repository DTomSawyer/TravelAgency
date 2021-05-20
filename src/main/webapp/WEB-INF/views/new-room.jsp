<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    <%@include file="/WEB-INF/resources/css/new-hotel.css" %>
</style>

<html>
<head>
    <title>Add a room</title>
</head>

<body>
<form:form method="post" action="/management/addRoom" modelAttribute="room">
    <table>
        <div>
        <label for="hotelName">Hotel</label>
        <select id="hotelName" name="hotelName">
            <c:forEach var="hotel" items="${hotels}">
                <option value="${hotel.name}">${hotel.name}</option>
            </c:forEach>
        </select>
        </div>

        <div>
        <label for="type">Type</label>
        <select id="type" name="type">
            <c:forEach var="type" items="${types}">
                <option value="${type}">${type}</option>
            </c:forEach>
        </select>
        </div>

        <div class="form-group">
            <label for="number" class="sr-only">Number</label>
            <input type="text" id="number" name="number" class="form-control" placeholder="Number" required>
        </div>

        <div class="form-group">
            <label for="price" class="sr-only">Price</label>
            <input type="text" id="price" name="price" class="form-control" placeholder="Price" required>
        </div>

        <p>${message}</p>

        <tr>
            <td><input type="submit" value="Add a room"/></td>
        </tr>
    </table>
</form:form>
</body>

</html>
