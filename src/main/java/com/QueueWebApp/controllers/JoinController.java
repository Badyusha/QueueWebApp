package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.JoinService;
import com.QueueWebApp.bll.services.SignUpService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class JoinController {

	private final JoinService joinService;

	@Autowired
	public JoinController(JoinService joinService) {
		this.joinService = joinService;
	}
	@GetMapping("/Join")
	public String Join(Model model) {
		return "Join";
	}

	@PostMapping("/Join")
	public String Join(HttpServletRequest request, @RequestParam String subjectName, @RequestParam String subgroup, @RequestParam LocalDate date, Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		joinService.AddUserToQueue(user.getId(), subjectName, subgroup, date);
		return "redirect:/Home";
	}
}
