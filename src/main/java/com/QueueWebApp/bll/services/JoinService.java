package com.QueueWebApp.bll.services;

import com.QueueWebApp.dal.database.DatabaseService;
import com.QueueWebApp.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JoinService {

	private final DatabaseService databaseService;

	@Autowired
	public JoinService(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
	public void AddUserToQueue(Long userId, String subjectName, Integer subgroup, LocalDate date) {
		Subject subject = new Subject(subjectName, subgroup, date);
		Long subjectId = databaseService.GetSubject(subject).getId();
		databaseService.AddUserToQueue(userId, subjectId);
	}
}