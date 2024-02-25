package com.QueueWebApp.services;

import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {
	public static String CurrentPasswordMatchesDesired(String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = ((User) session.getAttribute("user"));

		String currentPassword = user.getPassword();
		byte[] passwordSalt = user.getPasswordSalt();

		String hashedPassword = EncryptionService.hashString(password, passwordSalt);

		return currentPassword.equals(hashedPassword) ? "New password cannot match the current" : null;
	}

	public static boolean ErrorIsNull(String error, HttpServletRequest request) {
		if (error != null) {
			HttpSession session = request.getSession();
			session.setAttribute("error", error);
			return false;
		}
		return true;
	}
}
