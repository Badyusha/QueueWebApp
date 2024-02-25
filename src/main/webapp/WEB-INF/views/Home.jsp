
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.QueueWebApp.models.Subject"%>
<%@ page import="java.util.List" %>
<%@ page import="com.QueueWebApp.models.User" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>

    <style>
        <%@include file="/WEB-INF/css/HomeStyle.css"%>
        <%@include file="/WEB-INF/css/MovingMenuStyle.css"%>
    </style>

    <script>
        <%@include file="/WEB-INF/script/MovingMenuScript.js"%>
    </script>

</head>
<body>

<%--<jsp:include page="MovingMenuCode.jsp" />--%>


    <div class="header">
        <a href="/Profile">
            <%= ((User) session.getAttribute("user")).getLogin() %>
        </a>
        <a href="/Profile">
            <span class="avatar">
                <img src="${pageContext.request.contextPath}/images/defaultAvatar.png" alt="Avatar">
            </span>
        </a>

    </div>

    <h1>
        <%
            List<Subject> subjectsList = (List<Subject>) session.getAttribute("subjectsList");
            if(subjectsList.isEmpty()){
				out.print("You are not registered on any lab yet");
            } else {
                out.print("You are registered on");
            }
        %>
    </h1>

    <div id="sample">
        <form method="post" th:action="@{/Home}" th:method="post" class="queue-form">
            <%
                for(Subject subject : (subjectsList)) {
                    if (subject == null) {
                        continue;
					}
            %>
            <button type="submit" name="action" value="<%= subject.getId() %>" class="queue-button">
                <div class="subject-subgroup-line">
                <%
                    Integer subgr = subject.getSubgroup();
                    String subgroup = (subgr == 0 ? "" : (" (" + subgr.toString() + ')'));
                    out.print(subject.getSubjectName() + subgroup);
                %>
                </div>
            <br>
                <div class="date-line">
                <%
                    out.print(subject.getDate());
                %>
                </div>

            </button>
            <br>
            <%
				}
            %>
            <button type="submit" name="action" value="Join" class="join-button">Join</button>
        </form>
    </div>

    <div class="links">
        <a href="https://github.com/Badyusha/QueueWebApp">
            <img src="${pageContext.request.contextPath}/images/github.png" alt="GitHub">
        </a>
    </div>

</body>
</html>
