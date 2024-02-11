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
    <title>Remove</title>
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
    <h1>What record do you want to remove</h1>

    <div id="sample" style="margin-top:20px;">
        <form method="post" th:action="@{/Remove}" th:method="post">
            <%
                for(Subject subject : ((List<Subject>) session.getAttribute("subjectsList"))) {
                    if (subject != null) {
            %>
            <input type="checkbox" name="selectedQueues" value="<%= subject.getId() %>">
            <%= subject.getSubjectName() %><br>
            <%
                    }
                }
            %>
            <button type="submit" name="action" value="remove">Remove</button>
            <button type="submit" name="action" value="cancel">Cancel</button>
        </form>

    </div>
</div>
</body>
</html>
