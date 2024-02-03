<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 03.02.2024
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            border:none;
            border-radius :5px;
            color:white;
            cursor:pointer
        }
        #join { background-color : skyblue;}
        #cancel { background-color : tomato;}
    </style>
</head>
<body>

<form action="/action_page.php">
    <h1>Join</h1>

    <label for="subject">Subject</label><br>
    <input type="text" id="subject" name="subject" value="САМПС" disabled><br><br>

    <label for="subgroup">Subgroup</label><br>
    <input type="text" id="subgroup" name="subgroup" value="1" disabled><br><br>

    <label for="date">Date</label><br>
    <input type="date" id="date" name="date" value="01/09" disabled><br><br>

    <button type = "submit"id = "join">Join </button>
    <button type = "button"id = "cancel">Cancel </button>
</form>

</body>
</html>

