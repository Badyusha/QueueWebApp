package com.QueueWebApp.services;

import com.QueueWebApp.database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
