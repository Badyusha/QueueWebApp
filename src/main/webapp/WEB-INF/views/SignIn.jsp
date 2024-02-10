<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 03.02.2024
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.QueueWebApp.models.User"%>
<html lang="en">
<head>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
</head>
<body>
<div class="container">
    <h1>Sign in</h1>
    <form method="post">
<%--        <label for="login" class="form-label">Login</label>--%>
        <input
                type="text"
                id="username"
                name="username"
                placeholder="Username"
        />

<%--        <label for="password" class="form-label">Password</label>--%>
        <input
                type="password"
                id="password"
                name="password"
                placeholder="Password"
        />

        <div class="error-message">
                <%
                    if( ((String)session.getAttribute("SignInError")) != null) {
                        out.println("Incorrect username or password");
                    }
                %>
        </div>

        <input type="submit" value="Sign in" />
    </form>
    <div class="create-account">
        <a href="/SignUp" class="href">Create account</a>
    </div>
</div>
</body>
</html>
