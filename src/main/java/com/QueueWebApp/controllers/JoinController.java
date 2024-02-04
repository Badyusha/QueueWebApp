package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.JoinService;
import com.QueueWebApp.bll.services.SessionService;
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
	public String join(Model model) {
		model.addAttribute("subjects", new String[]{"ООПиП", "СМиФ", "БД"});
		model.addAttribute("subgroups", new String[]{"1 подгруппа", "2 подгруппа", "Общая"});
		return "Join";
	}

	@PostMapping("/Join")
	public String processForm(HttpServletRequest request,
							  @RequestParam String subject,
							  @RequestParam String subgroup,
							  @RequestParam String date,
							  @RequestParam String action,
							  Model model) {
		User user = SessionService.UserIsInSession(request);

		if (user == null) {
			return "redirect:/SignIn";
		}


		if ("join".equals(action)) {
			try {
				LocalDate parsedDate = LocalDate.parse(date);
				joinService.AddUserToQueue(user.getId(), subject, subgroup, parsedDate);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return "redirect:/Home";
	}


}


