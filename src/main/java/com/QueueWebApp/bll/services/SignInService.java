package com.QueueWebApp.bll.services;


import com.QueueWebApp.dal.database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {

	private final DatabaseService databaseService;

	@Autowired
	public SignInService(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
	public boolean SuccessfulAuthorization(String login, String password){
		return databaseService.UserExists(login,password);
	}

}
