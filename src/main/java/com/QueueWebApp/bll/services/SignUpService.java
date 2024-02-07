package com.QueueWebApp.bll.services;

import com.QueueWebApp.dal.database.DatabaseService;
import com.QueueWebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

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

		if (words.length != 2) {
			arr[0] = "Full name must contain 2 words";
		}
		if (login.length() < 7) {
			arr[1] = "Login should be at least 7 symbols";
		}

		if (login.length() > 20) {
			arr[1] = "Login should be less than 20 symbols";
		}
		if (databaseService.IsLoginInDb(login) != null) {
			arr[1] = "Login already in use, enter another";
		}

		arr[2] = passwordsAreCorrect(password, repeatPassword);
		// Проверка корректности логина
		String loginValidationResult = validateLogin(login);
		if (loginValidationResult != null) {
			arr[1] = loginValidationResult;
		}

		return arr;
	}

	public static String passwordsAreCorrect(String password, String repeatedPassword) {
		if (password.length() > 30) {
			return "Password should be less than 30 symbols";
		}
		if (!password.equals(repeatedPassword)) {
			return "Passwords doesn't match";
		}
		if (password.length() < 10) {
			return "Password should be at least 10 symbols";
		}
		if (!Pattern.matches("[a-zA-Z0-9!@#$%^&*]+", password)) {
			return "Incorrect password";
		}

		return null;
	}

	// Валидация логина
	public static String validateLogin(String login) {
		if (!Pattern.matches("[a-zA-Z0-9_.]+", login)) {
			return "Incorrect username";
		}
		return null;
	}

	public User RegisterUser(String fullName, String login, String password) {
		byte[] passwordSalt = EncryptionService.getSalt();
		String hashedPassword = EncryptionService.hashString(password, passwordSalt);

		return databaseService.AddUserToDb(fullName, login, hashedPassword, passwordSalt);
	}
}