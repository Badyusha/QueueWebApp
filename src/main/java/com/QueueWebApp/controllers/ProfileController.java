package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.SessionService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
	@GetMapping("/Profile")
	public String SignIn(HttpServletRequest request, Model model) {
		User user = SessionService.UserIsInSession(request);

		if(user == null) {
			return "redirect:/SignIn";
		}

		model.addAttribute("name", user.getFullName());
		model.addAttribute("login", user.getLogin());
		return "Profile";
	}

	@PostMapping("/Profile")
	public String ProcessSignInForm(@RequestParam String login, @RequestParam String password, Model model) {
		return "redirect:/Home";
	}
}
