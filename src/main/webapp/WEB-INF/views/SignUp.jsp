<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 03.02.2024
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign up to App</title>

  <style>
    <%@include file="/WEB-INF/css/SignUpStyle.css"%>
  </style>

</head>
<body>
<div class="container">
  <h1>Sign up</h1>
  <form method="post">
<%--    <label for="fullName">Full name</label>--%>
    <input
            type="text"
            id="fullName"
            name="fullName"
            placeholder="Full name"
            value="<%
             String fullName = (String) session.getAttribute("fullName");
             if(fullName != null){
               out.println(fullName);
             }
             %>"
    />
    <div class="error-message">
      <%
        String nameError = (String) session.getAttribute("fullNameError");
        if(nameError != null) {
          out.println(nameError);
        }
      %>
    </div>

<%--    <label for="login">Login</label>--%>
    <input
            type="text"
            id="login"
            name="login"
            placeholder="Username"
            value="<%
              String username = (String) session.getAttribute("login");
              if(username != null){
                out.println(username);
              }
             %>"
    />

    <div  class="error-message">
      <% String loginError = (String) session.getAttribute("loginError");
          if(loginError != null) {
            out.println(loginError);
          }
      %>
    </div>

<%--    <label for="password">Password</label>--%>
    <input
            type="password"
            id="password"
            name="password"
            placeholder="Password"
    />
<%--    <label for="repeatPassword">Repeat Password</label>--%>
    <input
            type="password"
            id="repeatPassword"
            name="repeatPassword"
            placeholder="Repeat password"
    />

    <div  class="error-message">
      <% String passwordError = (String) session.getAttribute("passwordError");
        if(passwordError != null) {
          out.println(passwordError);
        }
      %>
    </div>

    <input type="submit" value="Register" />
  </form>
  <div class="sign-in">
    <a href="/SignIn" class="href">Sign In</a>
  </div>
</div>
</body>
</html>
