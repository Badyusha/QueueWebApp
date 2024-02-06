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

import java.util.ArrayList;
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
    public User AddUserToDb(String fullName, String login, String passwordHash, byte[] passwordSalt) {
        return userRepository.save(new User(fullName, login, passwordHash, passwordSalt));
    }
    public User UpdateUserInDb(User user) {
        return userRepository.save(new User(user.getId(), user.getFullName(), user.getLogin(), user.getPassword(), user.getPasswordSalt()));
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

    public boolean deleteUser(User user) {
        try {
            userRepository.delete(user);
        } catch(Exception e){
            e.getStackTrace();
            return false;
        }
        return true;
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

    public List<Subject> GetUserSubjects(Long userId) {
        List<Long> userSubjectsId = this.queueRepository.GetUserSubjectsId(userId);

        List<Subject> userSubjects = new ArrayList<>();

        for(Long subjectId : userSubjectsId) {
            try {
                userSubjects.addAll(this.subjectRepository.GetUserSubjects(subjectId));
            } catch(NullPointerException e){
                e.getStackTrace();
                userSubjects = null;
            }
        }
        return userSubjects;
    }
}
