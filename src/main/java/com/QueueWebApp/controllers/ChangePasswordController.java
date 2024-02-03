package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.ChangePasswordService;
import com.QueueWebApp.bll.services.EncryptionService;
import com.QueueWebApp.bll.services.SessionService;
import com.QueueWebApp.bll.services.SignUpService;
import com.QueueWebApp.dal.database.DatabaseService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class ChangePasswordController {
	private final DatabaseService databaseService;

	@Autowired
	public ChangePasswordController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}


	@GetMapping("/ChangePassword")
	public String SignIn(HttpServletRequest request) {
		User user = SessionService.UserIsInSession(request);
		if(user == null) {
			return "redirect:/SignIn";
		}

		return "forward:/WEB-INF/views/changePassword.jsp";
	}

	@PostMapping("/ChangePassword")
	public String ProcessSignInForm(@RequestParam String password, @RequestParam String repeatedPassword,
									@RequestParam String action, HttpServletRequest request)
	{
		if(action.equals("cancel")) {
			return "redirect:/Profile";
		}

		String error = SignUpService.passwordsAreCorrect(password, repeatedPassword);
		if (!ChangePasswordService.ErrorIsNull(error, request)) {
			return "redirect:/ChangePassword";
		}

		error = ChangePasswordService.CurrentPasswordMatchesDesired(password, request);
		if(!ChangePasswordService.ErrorIsNull(error, request)) {
			return "redirect:/ChangePassword";
		}

		User user = (User) request.getSession().getAttribute("user");
		String hashedPassword = EncryptionService.hashString(password, user.getPasswordSalt());

		user.setPassword(hashedPassword);
		try {
			databaseService.UpdateUserInDb(user);
			request.setAttribute("user", user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/Profile";
	}
}
