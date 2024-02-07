<%@ page import="com.QueueWebApp.models.Subject" %>
<%@ page import="com.QueueWebApp.models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 03.02.2024
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Queue Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: white;
        }
        h1 {
            font-size: 32px;
        }
        p {
            margin-bottom: 5px;
        }
        ul {
            list-style-type: none;
            padding-left: 0;
        }
        li {
            font-size: 24px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<h1>
    <%
    Subject subject = (Subject) session.getAttribute("subjectOfTheFinalUsersList");
	List<User> finalUsersList = (List<User>) session.getAttribute("finalUsersList");

	out.print(subject.getSubjectName());
    %>
</h1>
<p>
    <%
        out.print(subject.getSubgroup() + " subgroup");
    %>
</p>
<p>
    <%
        out.println(subject.getDate());
		if(finalUsersList == null) {
            out.println("QUEUE IS NOT READY... BITCH");
        } else {
    %>
</p>

<h2>Queue:</h2>

<ul>
    <%
            int counter = 1;
		    for(User user : finalUsersList) {
    %>
    <li>
        <%
                out.print(counter + ". " + user.getFullName());
				++counter;
        %>
    </li>
    <%
			}
        }
    %>
<%--    <li>1. dfgdgfgd ●</li>--%>
<%--    <li>1. dfgdgfgd ●</li>--%>
<%--    <li>1. dfgdgfgd ●</li>--%>
</ul>

<!-- Hamburger Menu Icon -->
<div style="font-size:36px; position:absolute; top:20px; right:20px;">☰</div>

</body>
</html>
