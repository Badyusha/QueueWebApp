<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 03.02.2024
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Data</title>
    <style>
        body {
            background-color: white;
            font-family: Arial, sans-serif;
        }
        h1 {
            color: black;
            text-align: center;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 4px;
            background-color: #f8f8f8;
        }
        input[type="submit"] {
            width: 100%;
            background-color: green;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .container {
            border-radius: 5px;
            background-color: white;
            padding: 20px;
            width: 300px;
            margin: auto;
            margin-top: 50px;
        }
        .create-account {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
        }
        .error-message{
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Sign in</h1>
    <form method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login" placeholder="Login" />

        <label for="password">Password</label>
        <input
                type="password"
                id="password"
                name="password"
                placeholder="Password"
        />
        <div th:if="${error != null}" th:text="${error}" class="error-message"></div>

        <input type="submit" value="Sign in" />
    </form>
    <div class="create-account">
        <a href="/SignUp">Create an account</a>
    </div>
</div>
</body>
</html>
