<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 03.02.2024
  Time: 23:22
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



<form method="post">
    <h1>Join</h1>

    <label for="subject">Subject</label><br>
    <select id="subject" name="subject">
        <%
            List<String> subjects = (List<String>) session.getAttribute("subjects");
            if (subjects != null) {
                for (String subject : subjects) {
        %>
        <option value="<%= subject %>"><%= subject %></option>
        <%
                }
            }
        %>
    </select><br><br>

    <label for="subgroup">Subgroup</label><br>
    <select id="subgroup" name="subgroup">
        <%
            List<String> subgroups = (List<String>) session.getAttribute("subgroups");
            if (subgroups != null) {
                for (String subgroup : subgroups) {
        %>
        <option value="<%= subgroup %>"><%= subgroup %></option>
        <%
                }
            }
        %>
    </select><br><br>

    <label for="date">Date</label><br>
    <input type="date" id="date" name="date"/><br><br>

    <button type="submit" id="join" name="action" value="join">Join</button>
    <button type="submit" id="cancel" name="action" value="cancel">Cancel</button>
</form>




</body>
</html>