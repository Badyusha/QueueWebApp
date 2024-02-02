package com.QueueWebApp.bll.services;

import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionService {
	public static User UserIsInSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (User) session.getAttribute("user");
	}
}
