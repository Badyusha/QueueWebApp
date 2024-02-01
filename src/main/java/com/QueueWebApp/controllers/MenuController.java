package com.QueueWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {
	@GetMapping("/Menu")
	public String SignIn(Model model) {
		return "Menu";
	}

	@PostMapping("/Menu")
	public String ProcessSignInForm(@RequestParam String login, @RequestParam String password, Model model) {

		return "Home";
	}
}
