package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.SessionService;
import com.QueueWebApp.dal.database.DatabaseService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
	private final DatabaseService databaseService;

	@Autowired
	public ProfileController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
	@GetMapping("/Profile")
	public String SignIn(HttpServletRequest request) {
		User user = SessionService.UserIsInSession(request);
		if(user == null) {
			return "redirect:/SignIn";
		}

		return "forward:/WEB-INF/views/Profile.jsp";
	}

	@PostMapping("/Profile")
	public String ProcessSignInForm(@RequestParam String action, HttpServletRequest request) {
		if (action.equals("changePassword")) {
			return "redirect:/ChangePassword";
		}
		if (action.equals("deleteAccount")) {
			return "redirect:/Confirmation";
		}
		if (action.equals("confirmDelete")) {
			User user = (User) request.getSession().getAttribute("user");

			if(!databaseService.deleteUser(user)) {
				return "forward:/WEB-INF/views/Profile.jsp";
			}

			request.getSession().invalidate();

			return "redirect:/SignIn";
		}

		return "redirect:/Home";
	}
}
