<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form action="available" method="get">
    <table>
        <label for="country">Pick Country:</label>
        <select id="country" name="country">
            <c:forEach var="country" items="${countries}">
                <option value="${country}">${country}</option>
            </c:forEach>
        </select>

        <div class="form-group">
            <%--@declare id="inputdate"--%>
            <label for="inputDate">Arrival Date:</label>
            <input type="date" class="form-control" name="arrivalDate" required>
        </div>

        <div class="form-group">
            <%--@declare id="inputdate"--%>
            <label for="inputDate">Departure Date:</label>
            <input type="date" class="form-control" name="departureDate" required>
        </div>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>