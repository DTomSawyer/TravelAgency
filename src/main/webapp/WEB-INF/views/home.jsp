<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form action="available" method="get">
    <table>
        </label for="country">Pick Country:</label>

        <select name="country">
            <c:forEach var="country" items="${countries}">
                <option value="${country}">"${country}"</option>
            </c:forEach>
        </select>
        <div>
            <label for="arrival">Arrival Date:</label>
            <input id="arrival" type="date" name="arrivalDate" required>
        </div>

        <div>
            <label for="departure">Departure Date:</label>
            <input id="departure" type="date" name="departureDate" required>
        </div>

        </tr>
        <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>