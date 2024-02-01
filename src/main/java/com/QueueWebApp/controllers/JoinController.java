package com.QueueWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
	@GetMapping("/Join")
	public String SignIn(Model model) {
		return "Join";
	}

	@PostMapping("/Join")
	public String ProcessSignInForm(@RequestParam String login, @RequestParam String password, Model model) {

		return "Home";
	}
}
