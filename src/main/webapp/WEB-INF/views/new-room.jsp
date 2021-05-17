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
    <title>Add a room</title>
</head>
<body>

<form method="post" action="/management/addRoom" modelAttribute="room">

    </label for="hotel">Hotel</label>
    <select name="hotel">
        <c:forEach var="hotel" items="${hotels}"> <%--????????--%>
            <option value="${hotel.name}">"${hotel.name}"</option>
        </c:forEach>
    </select>

    <p>
        <label for="type" class="sr-only">Type</label>
        <input type="text" id="type" name="type" class="form-control" placeholder="Type" required>
    </p>

    <p>
        <label for="number" class="sr-only">Number</label>
        <input type="text" id="number" name="number" class="form-control" placeholder="Number" required>
    </p>

    <p>
        <label for="price" class="sr-only">Price</label>
        <input type="text" id="price" name="price" class="form-control" placeholder="Price" required>
    </p>

    <button type="submit">Add a room</button>
</form>

</body>
</html>
