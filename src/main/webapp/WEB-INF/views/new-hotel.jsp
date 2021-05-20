<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@ page isELIgnored="false" %>
</head>
<style>
    <%@include file="/WEB-INF/resources/css/new-hotel.css" %>
</style>

<html>
<head>
    <title>Add a hotel</title>
</head>
<body>

<form:form method="post" action="/management/addHotel" modelAttribute="hotel">
    <p>
        <label for="name">Name</label>
            <form:input type="text" path="name" id="Name" placeholder="Name"/>
            <form:errors path="name"/>
<%--    <p>${message}</p>--%>
    </p>

    </label for="country">Country</label>
    <select name="country">
        <c:forEach var="country" items="${countries}">
            <option value="${country}">"${country}"</option>
        </c:forEach>
    </select>

    <p>
        <label for="city">City</label>
        <input type="text" id="city" name="city" class="form-control" placeholder="City" required>
    </p>
    <button type="submit">Add a hotel</button>
</form:form>

</body>
</html>
