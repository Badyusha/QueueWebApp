package com.QueueWebApp.bll.services;

import com.QueueWebApp.dal.database.DatabaseService;
import com.QueueWebApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Service
public class LoginService {

    private final DatabaseService databaseService;


    @Autowired
    public LoginService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void RegisterUser(String fullName, String login, String password) {

        byte[] passwordSalt = getSalt();
        String hashedPassword = hashString(password, passwordSalt);

        databaseService.AddUserToDb(fullName, login, hashedPassword, passwordSalt);
    }

    public boolean IsUserInDb(String login) {
        return databaseService.IsLoginInDb(login);
    }

    private static byte[] getSalt() {
        // Генерация случайной соли
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static String hashString(String password, byte[] salt) {
        int iterations = 10000;
        int keyLength = 256;

        try {
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(salt) + "$" + Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return null;
    }
}