
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.QueueWebApp.models.Subject"%>
  <%@ page import="java.util.List" %>
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
