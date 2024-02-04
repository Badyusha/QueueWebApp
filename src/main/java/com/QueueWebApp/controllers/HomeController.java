package com.QueueWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/Home")
	public String Home(Model model) {
		return "Home";
	}

	@PostMapping("/Home")
	public String Home(@RequestParam String login, @RequestParam String password, Model model) {
		return "";
	}
}
