<%--
  Created by IntelliJ IDEA.
  User: kwint
  Date: 15.05.2021
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a hotel</title>
</head>
<body>

<form method="post" action="/management/addHotel" modelAttribute="hotel">
    <p>
        <label for="name" class="sr-only">Name</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Name" required autofocus>
    </p>

    </label for="country">Country</label>
    <select name="country">
        <c:forEach var="country" items="${countries}">
            <option value="${country}">"${country}"</option>
        </c:forEach>
    </select>

    <p>
        <label for="city" class="sr-only">City</label>
        <input type="text" id="city" name="city" class="form-control" placeholder="City" required>
    </p>
    <button type="submit">Add a hotel</button>
</form>

</body>
</html>
