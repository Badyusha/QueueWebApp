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
        <%@include file="/WEB-INF/css/ProfileStyle.css"%>
        <%@include file="/WEB-INF/css/MovingMenuStyle.css"%>
    </style>

    <script>
        <%@include file="/WEB-INF/script/MovingMenuScript.js"%>
        <%@include file="/WEB-INF/script/ProfileScript.js"%>
    </script>

</head>
<body>

<jsp:include page="MovingMenuCode.jsp" />

    <div class="profile">
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

        <form method="post" th:action="@{/Profile}" th:method="post">
            <button type="submit" name="action" value="changePassword">Change password</button>
            <button type="button" onclick="showConfirmation()">Delete account</button>
        </form>

        <!-- Confirmation form -->
        <div id="confirmationModal" style="display:none">
            <h2>Are you sure you wanna delete your account?</h2>
            <form method="post" th:action="@{/Profile}" th:method="post">
                <button type="submit" name="action" value="confirmDelete">Yeap</button>
                <button type="button" onclick="hideConfirmation()">Cancel</button>
            </form>
        </div>

    </div>

</body>
</html>
