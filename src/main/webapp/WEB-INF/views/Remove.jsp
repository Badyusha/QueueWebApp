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
    <title>Remove Record</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 300px;
            margin: auto;
        }
        button {
            padding: 10px 20px;
            margin-top: 10px;
            width: calc(100% - 20px);
            border: none;
            border-radius: 5px;
        }
        .remove {
            background-color: #ff5c5c;
            color: white;
        }
        .cancel {
            background-color: #ccc;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>What record do you want to remove</h2>

    <button>САПрис</button>
    <button>САПрис</button>
    <button>САПрис</button>

    <button class="remove">Remove</button>
    <button class="cancel">Cancel</button>
</div>

</body>
</html>

