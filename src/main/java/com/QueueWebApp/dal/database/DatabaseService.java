package com.QueueWebApp.dal.database;

import com.QueueWebApp.bll.services.EncryptionService;
import com.QueueWebApp.models.Queue;
import com.QueueWebApp.models.Subject;
import com.QueueWebApp.models.User;
import com.QueueWebApp.repo.QueueRepository;
import com.QueueWebApp.repo.SubjectRepository;
import com.QueueWebApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final QueueRepository queueRepository;
    @Autowired
    public DatabaseService(UserRepository userRepository, SubjectRepository subjectRepository, QueueRepository queueRepository) {
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
        this.queueRepository = queueRepository;
    }

    public void AddUserToDb(String fullName, String login, String passwordHash, byte[] passwordSalt) {
        userRepository.save(new User(fullName, login, passwordHash, passwordSalt));
    }

    public User GetUserByLogin(String login) {
        Iterable<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public boolean UserExists(String login, String password) {
        User user = GetUserByLogin(login);

        if(user == null) {
            return false;
        }

        byte[] passwordSalt = user.getPasswordSalt();
        String hashedPassword = EncryptionService.hashString(password, passwordSalt);

        return user.getPassword().equals(hashedPassword);
    }


    public Subject GetSubject(Subject subject) {
        Iterable<Subject> subjects = subjectRepository.findAll();

        for (Subject item : subjects) {
            if (item.getSubjectName().equals(subject.getSubjectName())
                    && item.getSubgroup().equals(subject.getSubgroup())
                    && item.getDate().equals(subject.getDate())) {
                return item;
            }
        }
        return null;
    }
    public void AddUserToQueue(Long userId, Long subjectId) {
        Queue queue = new Queue(userRepository.getReferenceById(userId), subjectRepository.getReferenceById(subjectId));
        queueRepository.save(queue);
    }
}
