<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>

    <style>
        <%@include file="/WEB-INF/css/ChangePasswordStyle.css"%>
    </style>

    <script>
        <%@include file="/WEB-INF/script/MovingMenuScript.js"%>
    </script>

</head>
<body>

<div class="profile">

    <form method="post" th:action="@{/ChangePassword}" th:method="post">
        <!-- Other form fields and user information -->

        <label for="newPassword">New password</label>
        <input
                type="password"
                id="newPassword" name="password"
                placeholder="New password"
        />

        <label for="repeatedPassword">Repeat password</label>
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

</body>
</html>
