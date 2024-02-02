package com.QueueWebApp.bll.services;

import com.QueueWebApp.dal.database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
	private final DatabaseService databaseService;

	@Autowired
	public SignUpService(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	public String[] CorrectData(String fullName, String login, String password, String repeatPassword) {
		String[] arr = {null, null, null};
		String[] words = fullName.split(" ");

		if(words.length != 2){
			arr[0] = "Full name must contain 2 words";
		}
		if(login.length() < 7){
			arr[1] = "Login should be at least 7 symbols";
		}
		if(password.length() < 10){
			arr[2] = "Password should be at least 10 symbols";
		}

		if(login.length() > 20){
			arr[1] = "Login should be less than 20 symbols";
		}
		if(password.length() > 30){
			arr[2] = "Password should be less than 30 symbols";
		}
		if(databaseService.IsLoginInDb(login) != null) {
			arr[1] = "Login already in use, enter another";
		}
		if(!password.equals(repeatPassword)) {
			arr[2] = "Password doesn't match";
		}

		return arr;
	}

	public void RegisterUser(String fullName, String login, String password) {

		byte[] passwordSalt = EncryptionService.getSalt();
		String hashedPassword = EncryptionService.hashString(password, passwordSalt);

		databaseService.AddUserToDb(fullName, login, hashedPassword, passwordSalt);
	}
}
