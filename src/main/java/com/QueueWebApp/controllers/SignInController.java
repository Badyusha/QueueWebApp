package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.SignInService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SignInController {

	@GetMapping("/SignIn")
	public String SignIn(Model model) {
		return "SignIn";
	}

	@PostMapping("/SignIn")
	public String ProcessSignInForm(@RequestParam String login,	@RequestParam String password, Model model) {
		int authorizationResult = SignInService.SuccessfulAuthorization(login, password);

		if(authorizationResult == SignInService.NoSuchUser){
			model.addAttribute("error", "Incorrect username or password");
			return "IncorrectAuthorization";
		}
		if(authorizationResult == SignInService.BadRequestError){
			model.addAttribute("error", "Failed to make database request");
			return "IncorrectAuthorization";
		}

		return "Home";
	}
}

