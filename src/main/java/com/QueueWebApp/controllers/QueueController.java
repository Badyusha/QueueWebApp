package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.QueueService;
import com.QueueWebApp.bll.services.SessionService;
import com.QueueWebApp.models.Subject;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class QueueController {
	private final QueueService queueService;

	@Autowired
	public QueueController(QueueService queueService) {
		this.queueService = queueService;
	}

	@GetMapping("/Queue/{subjectId}")
	public String Queue(@PathVariable Long subjectId, HttpServletRequest request) {
		User user = SessionService.UserIsInSession(request);
		if(user == null) {
			return "redirect:/SignIn";
		}

		Subject subject = queueService.GetQueueRepository().GetSubjectById(subjectId);
		List<User> finalUsersList = queueService.GetFinalUsersQueueList(subject);

		request.getSession().setAttribute("finalUsersList", finalUsersList);
		request.getSession().setAttribute("subjectOfTheFinalUsersList", subject);

		return "forward:/WEB-INF/views/Queue.jsp";
	}

	@PostMapping("/Queue/{id}")
	public String ProcessQueue(@PathVariable String id, HttpServletRequest request) {

		return "redirect:/Home";
	}
}
