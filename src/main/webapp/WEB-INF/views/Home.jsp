<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 03.02.2024
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
        }
        button {
            padding: 10px 20px;
            margin-top: 20px;
            font-size: large;
        }
        #join {
            background-color: blue;
            color:white;
        }

        #remove {
            background-color:red;
            color:white;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>You registratied</h1>

    <div id="sample" style="margin-top:20px;">
        <button>САМпс</button><br/>
        <button>САМпс</button><br/>
        <button>САМпс</button><br/>
    </div>

    <!-- Join and Remove buttons -->
    <button id="join">Join</button>
    <button id="remove">Remove</button>

</div>

<script type='text/javascript'>
    // You can add interactivity with JavaScript here
    // For example, handling clicks on buttons
    document.getElementById('join').addEventListener('click', function() {
        alert('Joined!');
    });

    document.getElementById('remove').addEventListener('click', function() {
        alert('Removed!');
    });
</script>

</body>
</html>

