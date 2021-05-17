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
  <title>Login</title>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/auth/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <p>
            <label for="email" class="sr-only">Email</label>
            <input type="text" id="email" name="email" class="form-control" placeholder="Email" required autofocus>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
<p><a href="/registration/register">Sign up</a></p>
</body>
</html>