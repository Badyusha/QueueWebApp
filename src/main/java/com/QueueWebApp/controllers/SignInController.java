package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.SessionService;
import com.QueueWebApp.bll.services.SignInService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;


@Controller
public class SignInController {
	private final SignInService	signInService;

	@Autowired
	public SignInController(SignInService signInService) {
		this.signInService = signInService;
	}

	@GetMapping("/SignIn")
	public String SignIn(HttpServletRequest request) {
		request.getSession().setAttribute("SignInError", null);
		User user = SessionService.UserIsInSession(request);
		if(user == null) {
			return "forward:/WEB-INF/views/SignIn.jsp";
		}
		return "redirect:/Home";
	}

	@PostMapping("/SignIn")
	public String ProcessSignInForm(@RequestParam String username, @RequestParam String password,
									HttpServletRequest request)
	{
		if(!signInService.SuccessfulAuthorization(username, password, request)) {
			request.getSession().setAttribute("SignInError", "Incorrect username or password");
			return "forward:/WEB-INF/views/SignIn.jsp";
		}
		return "redirect:/Home";
	}
}

