package com.QueueWebApp.controllers;

import com.QueueWebApp.models.User;
import com.QueueWebApp.repo.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.module.Configuration;
import java.net.SocketOption;
import java.util.List;

@Controller()
public class SignUpController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/SignUp")
    public String SignUp(Model model) {
        return "SignUp";
    }

    @PostMapping("/SignUp")
    public String SignUp(
            @RequestParam  String fullName,
            @RequestParam  String login,
            @RequestParam  String password,
            @RequestParam  String repeatPassword,
            Model model) {


        String[] dataErrorArray = CorrectData(fullName, login, password);



        if(dataErrorArray[0] != null || dataErrorArray[1] != null) {
            model.addAttribute("fullName", fullName);
            model.addAttribute("login", login);

            model.addAttribute("fullNameError", dataErrorArray[0]);
            model.addAttribute("loginError", dataErrorArray[1]);
            model.addAttribute("passwordError", dataErrorArray[2]);
            return "ErrorSignUp";
        } else if (!password.equals(repeatPassword)) {
            model.addAttribute("fullName", fullName);
            model.addAttribute("login", login);

            model.addAttribute("passwordMatch", "password doesn't match");
            return "ErrorSignUp";
        } else {
            try {

                User user = new User(fullName, login, password);
                userRepository.save(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return "SignUp";
    }


    public String[] CorrectData(String fullName, String login, String password) {
        String[] arr = {null, null, null};
        String[] words = fullName.split(" ");



        if(words.length != 2){
            arr[0] = "Full name must contain 2 words";
        }
        if(login.length() < 7){
            arr[1] = "Login should be at least 7 symbols";
        }
        if(password.length() < 10){
            arr[2] = "Password should be at least 10 symbols";
        }

        if(login.length() > 20){
            arr[1] = "Login should be less than 20 symbols";
        }
        if(password.length() > 30){
            arr[2] = "Password should be less than 30 symbols";
        }

        return arr;
    }
}
