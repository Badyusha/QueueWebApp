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
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: white;
            display: flex;
            flex-direction: column;
        }
        h1 {
            font-size: 32px;
            margin-bottom: 10px;
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
        #menuContainer {
            display: flex;
            justify-content: flex-end;
            align-items: flex-start;
            position: fixed;
            top: 0;
            right: 0;
        }
        #menuIcon {
            font-size: 36px;
            cursor: pointer;
            margin-right: 20px;
            transition: margin-right 0.3s ease-in-out;
        }
        #menu {
            position: fixed;
            top: 0;
            right: 0;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            transform: translateX(100%);
            transition: transform 0.3s ease-in-out;
        }

        #menu.show, #menuIcon.show {
            transform: translateX(0);
        }

        #menuIcon.show {
            margin-right: 20px; /* Установите начальное значение */
        }
    </style>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var menuIcon = document.getElementById("menuIcon");
            var menu = document.getElementById("menu");
            var isMenuVisible = false;

            menuIcon.addEventListener("click", function() {
                isMenuVisible = !isMenuVisible;

                if (isMenuVisible) {
                    menu.style.transform = "translateX(0)";
                    menuIcon.style.marginRight = "220px"; /* Измените значение на нужное вам */
                } else {
                    menu.style.transform = "translateX(100%)";
                    menuIcon.style.marginRight = "20px"; /* Измените значение на начальное */
                }
            });

            document.addEventListener("click", function(event) {
                var isClickInsideMenu = menu.contains(event.target);
                var isClickOnIcon = menuIcon.contains(event.target);

                if (!isClickInsideMenu && !isClickOnIcon && isMenuVisible) {
                    isMenuVisible = false;
                    menu.style.transform = "translateX(100%)";
                    menuIcon.style.marginRight = "20px"; /* Измените значение на начальное */
                }
            });
        });
    </script>
</head>
<body>

<div id="menuContainer">
    <!-- Hamburger Menu Icon -->
    <div id="menuIcon">&#9776;</div>

    <!-- Hidden Menu -->
    <div id="menu">
        <jsp:include page="//WEB-INF//views//Menu.jsp" />
    </div>
</div>

<div>
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

</body>
</html>
