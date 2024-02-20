
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

<div>
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

    <div id="sample" style="margin-top:20px;">
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
            <button type="submit" name="action" value="join" class="join-button">Join</button>
        </form>
    </div>

<%--    <form method="post" th:action="@{/Home}" th:method="post" class="join-buttons-form">--%>
<%--        <button type="submit" name="action" value="join" class="join-button">Join</button>--%>
<%--    </form>--%>

</div>

</body>
</html>
