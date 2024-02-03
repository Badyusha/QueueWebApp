<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 03.02.2024
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.QueueWebApp.models.User"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .profile {
            max-width: 400px;
            margin: auto;
        }
        .avatar {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background-color: grey;
            margin: auto;
        }
        .user_info, button {
            /*width: calc(100% - 20px);*/
            padding: 10px;
            margin-bottom: 20px;
        }
        .home {
            text-align: left;
            margin-top: 20px;
            font-size: 14px;
        }
        .label {
            color: grey;
            font-size: 10px;
        }

    </style>
</head>
<body>
    <div class="profile">
        <div class="home">
            <a href="/Home">Home</a>
        </div>

        <div class="avatar"></div>

        <div class="label">Name</div>
        <div class="user_info">
            <%
                out.println(((User)session.getAttribute("user")).getFullName());
            %>
        </div>
        <div class="label">Login</div>
        <div class="user_info">
            <%
                out.println(((User)session.getAttribute("user")).getLogin());
            %>
        </div>

        <form method="post" th:action="@{/Profile}" th:object="${user}" th:method="post">
            <button type="submit" name="action" value="changePassword">Change password</button>
            <button type="submit" name="action" value="deleteAccount">Delete account</button>
        </form>

    </div>

</body>
</html>
