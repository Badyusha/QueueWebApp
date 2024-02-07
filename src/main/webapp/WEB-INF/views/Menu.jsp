<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 07.02.2024
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Join Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
        }
        input[type=text], input[type=date] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
        }
        button {
            padding: 10px 20px;
            margin-top: 20px;
            font-size: large;
        }
        .container {
            align-content: center;
        }
    </style>
</head>
<body>


<div class="container">
    <h1>Menu</h1>

    <form method="post" th:action="@{/Menu}" th:method="post">
        <button type="submit"  name="action" value="profile">Profile</button><br>
        <button type="submit" name="action" value="about app">About app</button><br>
        <button type="submit" name="action" value="home">Home</button><br>
    </form>
</div>




</body>
</html>