
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.QueueWebApp.models.Subject"%>
  <%@ page import="java.util.List" %>
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

<jsp:include page="MovingMenuCode.jsp" />

<div class="container">
    <h1>You registered</h1>

    <div id="sample" style="margin-top:20px;">
        <form method="post" th:action="@{/Home}" th:method="post">
            <%
                for(Subject subject : ((List<Subject>) session.getAttribute("subjectsList"))) {
                    if (subject != null) {
            %>
            <button type="submit" name="action" value="<%out.print(subject.getId());%>">
            <%
                        out.println(subject.getSubjectName());
                    }
            %>
            </button><br>
            <%
				}
            %>
        </form>
    </div>

    <!-- Join and Remove buttons -->
    <form method="post" th:action="@{/Home}" th:method="post">
        <button type="submit" name="action" value="join">Join</button>
        <button type="submit" name="action" value="remove">Remove</button>
    </form>

</div>

</body>
</html>
