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
import java.util.ArrayList;
import java.util.List;

@Controller
public class JoinController {
	private final JoinService joinService;
	@Autowired
	public JoinController(JoinService joinService) {
		this.joinService = joinService;
	}
	@GetMapping("/Join")
	public String join(HttpServletRequest request, Model model) {
		User user = SessionService.UserIsInSession(request);
		if(user == null) {
			return "redirect:/SignIn";
		}

		List<String> subjectsList = new ArrayList<>();
		subjectsList.add("ООПиП");
		subjectsList.add("СМыФ");
		subjectsList.add("САИПиС");

		List<String> subgroupsList = new ArrayList<>();
		subgroupsList.add("1");
		subgroupsList.add("2");
		subgroupsList.add("Общая");

		request.getSession().setAttribute("subjects", subjectsList);
		request.getSession().setAttribute("subgroups", subgroupsList);

		return "forward:/WEB-INF/views/Join.jsp";
	}

	@PostMapping("/Join")
	public String processForm(HttpServletRequest request,
							  @RequestParam String subject,
							  @RequestParam Integer subgroup,
							  @RequestParam String date,
							  @RequestParam String action)
	{
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