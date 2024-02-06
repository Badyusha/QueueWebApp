package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.HomeService;
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
public class HomeController {
	private final HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("/Home")
	public String Home(HttpServletRequest request) {
		User user = SessionService.UserIsInSession(request);
		if(user == null) {
			return "redirect:/SignIn";
		}

		// set the subjects list into session
		request.getSession().setAttribute("subjectsList",
				this.homeService.GetDataBaseService().GetUserSubjects(user.getId()));

		return "forward:/WEB-INF/views/Home.jsp";
	}

	@PostMapping("/Home")
	public String ProcessHome(@RequestParam String action, HttpServletRequest request) {
		if(action.equals("join")){
			return "redirect:/Join";
		}

		if(action.equals("remove")){
			return "redirect:/Remove";
		}

		return "redirect:/Queue/" + action;
	}
}

