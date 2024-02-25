package com.QueueWebApp.controllers;

import com.QueueWebApp.services.HomeService;
import com.QueueWebApp.services.SessionService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	private final HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("/Home")
	public String SignIn(HttpServletRequest request) {
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
	public String ProcessSignInForm(@RequestParam String action, HttpServletRequest request) {
		if(action.equals("Join")){
			return "redirect:/Join";
		}

		if(action.equals("profile")){
			return "redirect:/Profile";
		}

		if(action.equals("home")){
			return "redirect:/Home";
		}

		return "redirect:/Queue/" + action;
	}
}

