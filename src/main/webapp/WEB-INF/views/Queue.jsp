<%@ page import="com.QueueWebApp.models.User" %>
<%@ page import="com.QueueWebApp.models.Subject" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Queue Page</title>

    <style>
        <%@include file="/WEB-INF/css/HeaderStyle.css"%>
        <%@include file="/WEB-INF/css/QueueStyle.css"%>
        <%@include file="/WEB-INF/css/LinksStyle.css"%>
    </style>

</head>
<body>

<jsp:include page="Header.jsp" />

<div style="text-align: center;">
    <h1>
        <%
            Subject subject = (Subject) session.getAttribute("subjectOfTheFinalUsersList");
            List<User> finalUsersList = (List<User>) session.getAttribute("finalUsersList");

            out.print(subject.getSubjectName());
        %>
    </h1>
    <p>
        <%
            Integer subgroup = subject.getSubgroup();
            out.print((subgroup.equals(0) ? "General" : subgroup) + " subgroup");
        %>
    </p>
    <p>
        <%
            out.println(subject.getDate());
        %>
    </p>
    <p>
        <%
            if(finalUsersList == null) {
                out.println("IT'S TOO EARLY or LAB HAS ALREADY PASSED... BITCH");
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
</div>

<jsp:include page="Links.jsp" />

</body>
</html>
