<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 5/4/21
  Time: 7:51 пп
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Register</title>
</head>
<body>
<div class="container">
    <form:form class="form-signin" method="post" action="/registration/register" modelAttribute="user" >
        <h2 class="form-signin-heading">Please sign in</h2>
        <p>
            <label for="email" class="sr-only">Email
            <form:input type="text" path="email" id="Email" placeholder="Email" />
            <form:errors path="email"/>
            </label>
        </p>
        <p>
            <label for="firstName" class="sr-only">First name</label>
            <form:input type="text" id="firstName" path="firstName" class="form-control" placeholder="First name" />
            <form:errors path="firstName"/>
        </p>
        <p>
            <label for="lastName" class="sr-only">Last name</label>
            <form:input type="text" id="lastName" path="lastName" class="form-control" placeholder="Last name" />
            <form:errors path="lastName"/>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <form:input type="password" id="password" path="password" class="form-control" placeholder="Password" />
            <form:errors path="password"/>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form:form>
</div>
</body>
</html>