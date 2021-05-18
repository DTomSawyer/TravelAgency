<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Add a room</title>
</head>

<body>
<form:form method="post" action="management/addRoom" modelAttribute="room">
    <table>
        <label for="hotel">Hotel</label>
        <select id="hotel" name="hotel">
            <c:forEach var="hotel" items="${hotels}">
                <option value="${hotel}">${hotel.name}</option>
            </c:forEach>
        </select>

        <div class="form-group">
            <label for="type" class="sr-only">Type</label>
            <input type="text" id="type" name="type" class="form-control" placeholder="Type" required>
        </div>

        <div class="form-group">
            <label for="number" class="sr-only">Number</label>
            <input type="text" id="number" name="number" class="form-control" placeholder="Number" required>
        </div>

        <div class="form-group">
            <label for="price" class="sr-only">Price</label>
            <input type="text" id="price" name="price" class="form-control" placeholder="Price" required>
        </div>

        <tr>
            <td><input type="submit" value="Add a room"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
