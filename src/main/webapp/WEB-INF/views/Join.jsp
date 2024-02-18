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
        <%@include file="/WEB-INF/css/JoinStyle.css"%>
    </style>

    <script>
        <%@include file="/WEB-INF/script/MovingMenuScript.js"%>
    </script>

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
    <button id="cancel" onclick="location.href='/Home'; return false;">Cancel</button>
</form>

<script>
    document.querySelector('form').addEventListener('submit', function(event) {
        event.preventDefault();

        var selectedDate = new Date(document.getElementById('date').value);
        var currentDate = new Date();

        var thresholdTime = new Date();
        thresholdTime.setHours(8);
        thresholdTime.setMinutes(0);

        if (currentDate.getTime() >= thresholdTime.getTime() && selectedDate <= currentDate) {
            alert("Registration for this item has been completed");
        } else {
            this.submit();
        }
    });
</script>



</body>
</html>