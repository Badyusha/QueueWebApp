<%@ page import="com.QueueWebApp.models.User" %>
<div class="header">
    <div  class="home-block">
        <a href="/Home">
            <span class="home">
                <img src="${pageContext.request.contextPath}/images/home.png" alt="Home">
            </span>
        </a>
    </div>
    <div class="profile-block">
        <a href="/Profile" class="nickname">
            <%= ((User) session.getAttribute("user")).getLogin() %>
        </a>
        <a href="/Profile">
            <span class="avatar">
                <img src="${pageContext.request.contextPath}/images/defaultAvatar.png" alt="Avatar">
            </span>
        </a>
    </div>
</div>