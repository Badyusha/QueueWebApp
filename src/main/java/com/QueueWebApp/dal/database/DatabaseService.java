package com.QueueWebApp.dal.database;

import com.QueueWebApp.bll.services.EncryptionService;
import com.QueueWebApp.models.User;
import com.QueueWebApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
    private final UserRepository userRepository;

    @Autowired
    public DatabaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void AddUserToDb(String fullName, String login, String passwordHash, byte[] passwordSalt) {
        userRepository.save(new User(fullName, login, passwordHash, passwordSalt));
    }

    public User IsLoginInDb(String login) {
        Iterable<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public User UserExists(String login, String password) {
        User user = IsLoginInDb(login);

        if(user == null) {
            return null;
        }

        byte[] passwordSalt = user.getPasswordSalt();
        String hashedPassword = EncryptionService.hashString(password, passwordSalt);

        return user.getPassword().equals(hashedPassword) ? user : null;
    }
}
