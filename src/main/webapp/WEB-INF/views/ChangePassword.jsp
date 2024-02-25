<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>

    <style>
        <%@include file="/WEB-INF/css/ChangePasswordStyle.css"%>
        <%@include file="/WEB-INF/css/HeaderStyle.css"%>
        <%@include file="/WEB-INF/css/LinksStyle.css"%>
    </style>

</head>
<body>

<jsp:include page="Header.jsp" />

<div class="profile">

    <form method="post" th:action="@{/ChangePassword}" th:method="post">
        <!-- Other form fields and user information -->

        <input
                type="password"
                id="newPassword" name="password"
                placeholder="New password"
        />

        <input
                type="password"
                id="repeatedPassword" name="repeatedPassword"
                placeholder="Repeat password"
        />

        <p class="error-message"><%
            String error = (String) session.getAttribute("error");
            if(error != null) {
                out.println(error);
            }
        %></p>

        <button type="submit" name="action" value="change">Change</button>
        <button type="submit" name="action" value="cancel">Cancel</button>
    </form>
</div>

<jsp:include page="Links.jsp" />

</body>
</html>
