<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<%--<h1>Welcome ${username}</h1>--%>
<%--<form action="filter">--%>
<%--    <input type="text" name="country">--%>
<%--    <input type="submit" value="Submit" />--%>
<%--</form>--%>

<form method="post">
<h3>List</h3>
<table border="1">
        <th>Pick country</th>


    <select name="country">
        <c:forEach var="country" items="${countries}">
            <option value="${country}">"${country}"</option>
        </c:forEach>
    </select>
</table>

<input type="submit" value="Submit" />

<a href="/hotel/management">Management</a>
</body>
</html>

