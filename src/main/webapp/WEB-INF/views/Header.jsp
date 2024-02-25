<%@ page import="com.QueueWebApp.models.User" %>
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