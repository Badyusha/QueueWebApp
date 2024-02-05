package com.QueueWebApp.bll.services;

import com.QueueWebApp.dal.database.DatabaseService;
import com.QueueWebApp.models.Subject;
import com.QueueWebApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
	private final DatabaseService databaseService;

	@Autowired
	public HomeService(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	public DatabaseService GetDataBaseService () {
		return this.databaseService;
	}
}
