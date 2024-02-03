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
    body {
      background-color: white;
      font-family: Arial, sans-serif;
    }
    h1 {
      color: black;
      text-align: center;
    }
    input[type="text"],
    input[type="password"] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
      border-radius: 4px;
      background-color: #f8f8f8;
    }
    input[type="submit"] {
      width: 100%;
      background-color: green;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    input[type="submit"]:hover {
      background-color: #45a049;
    }
    .container {
      border-radius: 5px;
      background-color: white;
      padding: 20px;
      width: 300px;
      margin: auto;
      margin-top: 50px;
    }
    .error-message {
      color: red;
      font-size: 12px
    }
    .sign-in {
      text-align: center;
      margin-top: 5px;
      font-size: 14px;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Sign up to App</h1>
  <form method="post">
    <label for="fullName">Full name</label>
    <input
            type="text"
            id="fullName"
            name="fullName"
            placeholder="Enter your first and last name"
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

    <label for="login">Login</label>
    <input
            type="text"
            id="login"
            name="login"
            placeholder="Enter your login"
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

    <label for="password">Password</label>
    <input
            type="password"
            id="password"
            name="password"
            placeholder="Enter your password"
    />
    <label for="repeatPassword">Repeat Password</label>
    <input
            type="password"
            id="repeatPassword"
            name="repeatPassword"
            placeholder="Enter your password again"
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
    <a href="/SignIn">Sign In</a>
  </div>
</div>
</body>
</html>
