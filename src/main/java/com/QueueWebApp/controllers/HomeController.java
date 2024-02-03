package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.SessionService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/Home")
	public String SignIn(HttpServletRequest request) {
		User user = SessionService.UserIsInSession(request);
		if(user == null) {
			return "redirect:/SignIn";
		}
		return "forward:/WEB-INF/views/Home.jsp";
	}

	@PostMapping("/Home")
	public String ProcessSignInForm() {
		return "";
	}
}
