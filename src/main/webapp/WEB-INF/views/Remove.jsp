<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 07.02.2024
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.QueueWebApp.models.Subject"%>
<%@ page import="java.util.List" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>

    <style>
        <%@include file="/WEB-INF/css/RemoveStyle.css"%>
    </style>

    <script>
        <%@include file="/WEB-INF/script/MovingMenuScript.js"%>
    </script>

</head>
<body>

<div class="container">
    <h1>What record do you want to remove</h1>

    <div id="sample" style="margin-top:20px;">
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
    </div>


</div>

</body>
</html>
