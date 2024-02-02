package com.QueueWebApp.controllers;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

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
