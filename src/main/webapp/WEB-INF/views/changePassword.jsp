<!DOCTYPE html>
<html lang="en">

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
        .error-message{
            color: red;
            font-size: 12px;
        }
    </style>
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
