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
    <form class="form-signin" method="post" action="/registration/register">
        <h2 class="form-signin-heading">Please sign in</h2>
        <p>
            <label for="email" class="sr-only">Email</label>
            <input type="text" id="email" name="email" class="form-control" placeholder="Email" required autofocus>
        </p>
        <p>
            <label for="firstName" class="sr-only">First name</label>
            <input type="text" id="firstName" name="firstName" class="form-control" placeholder="First name" required>
        </p>
        <p>
            <label for="lastName" class="sr-only">Last name</label>
            <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Last name" required>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>
</div>
</body>
</html>