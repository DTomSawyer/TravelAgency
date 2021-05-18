<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Users</title>
</head>

<body>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="user" items="${users}">

        <c:url var="ordersLink" value="/getOrders">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <sf:form method="get" action="${ordersLink}">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>
                    <button type="submit">See orders</button>
                </td>
            </tr>
        </sf:form>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
