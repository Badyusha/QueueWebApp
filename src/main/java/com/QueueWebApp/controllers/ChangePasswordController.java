package com.QueueWebApp.controllers;

import com.QueueWebApp.services.ChangePasswordService;
import com.QueueWebApp.services.EncryptionService;
import com.QueueWebApp.services.SessionService;
import com.QueueWebApp.services.SignUpService;
import com.QueueWebApp.database.DatabaseService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController {
	private final DatabaseService databaseService;

	@Autowired
	public ChangePasswordController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}


	@GetMapping("/ChangePassword")
	public String ChangePassword(HttpServletRequest request) {
		User user = SessionService.UserIsInSession(request);
		if(user == null) {
			return "redirect:/SignIn";
		}

		return "forward:/WEB-INF/views/ChangePassword.jsp";
	}

	@PostMapping("/ChangePassword")
	public String ProcessChangePassword(@RequestParam String password, @RequestParam String repeatedPassword,
									@RequestParam String action, HttpServletRequest request)
	{
		if(action.equals("cancel")) {
			return "redirect:/Profile";
		}

		if(action.equals("profile")){
			return "redirect:/Profile";
		}

		if(action.equals("home")){
			return "redirect:/Home";
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
