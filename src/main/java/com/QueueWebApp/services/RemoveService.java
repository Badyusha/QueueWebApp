package com.QueueWebApp.services;

import com.QueueWebApp.database.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveService {
    private final DatabaseService databaseService;

    @Autowired
    public RemoveService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public DatabaseService GetDataBaseService () {
        return this.databaseService;
    }

    public void RemoveUserFromQueue(Long subjectId, Long userId) {
        databaseService.RemoveUserFromQueue(subjectId, userId);
    }
}
