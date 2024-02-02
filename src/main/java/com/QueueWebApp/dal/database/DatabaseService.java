package com.QueueWebApp.dal.database;

import com.QueueWebApp.models.User;
import com.QueueWebApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {


    private final UserRepository userRepository;

    @Autowired
    public DatabaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void AddUserToDb(String fullName, String login, String passwordHash, byte[] passwordSalt) {
        User user = new User(fullName, login, passwordHash, passwordSalt);
        userRepository.save(user);
    }

    public boolean IsLoginInDb(String login) {
        Iterable<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

}
