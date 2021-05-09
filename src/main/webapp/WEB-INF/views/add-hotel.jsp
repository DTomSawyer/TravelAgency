<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Hotel</title>
</head>
<body>
<p><b>Add New Hotel</b></p>
<form:form modelAttribute="hotel" action="saveNew" method="post">
    <table>
        <form:hidden path="id"/>
        <tr>
            <td>Name</td>
            <td><form:input path="name" type="text"/></td>
        </tr>
        <tr>
            <td>Country</td>
            <td><form:input path="country" type="text"/></td>
        </tr>
            <%--        <tr>--%>
            <%--            <td>Rooms</td>--%>
            <%--            <td><form:input path="rooms" type="number"/></td>--%>
            <%--        </tr>--%>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>