<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make Order</title>
</head>
<body>

<p><b><h1>Add New Order</h1></b></p>
<form:form modelAttribute="order" action="addOrder">
    <table>
        <form:hidden path="order_id"/>
        <form:hidden path="hotel" value="${hotelname}"/>
        <tr>
            <td><h2>Hotel: ${hotelname}</h2></td>
        </tr>
        <tr>
            <td>Order name:</td>
            <td><form:input path="ordername" type="text"/></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email" type="text"/></td>
        </tr>
        <tr>
            <td>Date:</td>
            <td><form:input path="date" type="date"/></td>
        </tr>
        <tr>
            <td>Room:</td>
            <td><form:input path="room" type="number"/></td>
        </tr>
        <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>\