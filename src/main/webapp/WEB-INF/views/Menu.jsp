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
        <%@include file="/WEB-INF/css/MenuStyle.css"%>
    </style>
</head>
<body>

<div class="container">
    <h1>Menu</h1>

    <form method="post" th:action="@{/Menu}" th:method="post">
        <button type="submit"  name="action" value="profile">Profile</button><br>
        <button type="submit" name="action" value="home">Home</button><br>
    </form>
</div>

</body>
</html>