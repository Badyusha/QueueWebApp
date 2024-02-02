package com.QueueWebApp.bll.services;


import com.QueueWebApp.dal.database.DatabaseService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {

	private final DatabaseService databaseService;

	@Autowired
	public SignInService(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
	public boolean SuccessfulAuthorization(String login, String password, HttpServletRequest request) {
		User user = databaseService.UserExists(login,password);
		if(user == null){
			return false;
		}
		HttpSession session = request.getSession();

		session.setAttribute("user", user);
		return true;
	}

}
