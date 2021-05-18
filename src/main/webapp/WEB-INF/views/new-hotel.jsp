<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Add a hotel</title>
</head>

<body>
<form:form method="post" action="management/addHotel" modelAttribute="hotel">
    <table>
        <div class="form-group">
            <label for="name" class="sr-only">Name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Name" required autofocus>
        </div>

        <label for="country">Country</label>
        <select id="country" name="country">
            <c:forEach var="country" items="${countries}">
                <option value="${country}">${country}</option>
            </c:forEach>
        </select>

        <div class="form-group">
            <label for="city" class="sr-only">City</label>
            <input type="text" id="city" name="city" class="form-control" placeholder="City" required>
        </div>

        <div>
            <c:if test="${isError}">
                <span>Invalid data</span>
            </c:if>
        </div>

        <tr>
            <td><input type="submit" value="Add a hotel"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
