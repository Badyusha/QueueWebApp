package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.SignInService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SignInController {
	private final SignInService	signInService;

	@Autowired
	public SignInController(SignInService signInService) {
		this.signInService = signInService;
	}

	@GetMapping("/SignIn")
	public String SignIn(Model model) {
		return "SignIn";
	}

	@PostMapping("/SignIn")
	public String ProcessSignInForm(@RequestParam String login,	@RequestParam String password,
									HttpServletRequest request, Model model)
	{
		if(!signInService.SuccessfulAuthorization(login, password, request)) {
			model.addAttribute("error", "Incorrect username or password");
			return "IncorrectAuthorization";
		}
		return "redirect:/Home";
	}
}

