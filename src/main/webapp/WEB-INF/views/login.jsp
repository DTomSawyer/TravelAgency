<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 5/4/21
  Time: 7:51 пп
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/resources/css/login.css"%></style>

<!DOCTYPE html>
<html lang="en">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600&display=swap" rel="stylesheet">

<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/auth/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <div class="form-control">
            <p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" placeholder="Username" required autofocus>
            </p>
            <p>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password"  placeholder="Password" required>
            </p>
        </div>
        <div class="btn__block">
            <button class="btn" type="submit">Sign in</button>
            <button class="btn"><a class="btn_out" href="/registration/register">Sign up</a></button>
        </div>
    </form>
</div>


</body>

</html>