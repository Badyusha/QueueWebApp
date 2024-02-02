package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class SignUpController {
    private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

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

        String[] dataErrorArray = signUpService.CorrectData(fullName, login, password, repeatPassword);

        if(dataErrorArray[0] != null || dataErrorArray[1] != null || dataErrorArray[2] != null) {
            model.addAttribute("fullName", fullName);
            model.addAttribute("login", login);

            model.addAttribute("fullNameError", dataErrorArray[0]);
            model.addAttribute("loginError", dataErrorArray[1]);
            model.addAttribute("passwordError", dataErrorArray[2]);
            return "ErrorSignUp";
        }
        try {
            signUpService.RegisterUser(fullName, login, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "SignUp";
    }
}