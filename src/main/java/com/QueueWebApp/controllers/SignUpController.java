package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.SignUpService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
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
        return "forward:/WEB-INF/views/SignUp.jsp";
    }

    @PostMapping("/SignUp")
    public String SignUp(
            @RequestParam  String fullName,
            @RequestParam  String login,
            @RequestParam  String password,
            @RequestParam  String repeatPassword,
            HttpServletRequest request)
    {
        String[] dataErrorArray = signUpService.CorrectData(fullName, login, password, repeatPassword);

        if(dataErrorArray[0] != null || dataErrorArray[1] != null || dataErrorArray[2] != null) {
            HttpSession session = request.getSession();
            session.setAttribute("fullName", fullName);
            session.setAttribute("login", login);
            session.setAttribute("fullNameError", dataErrorArray[0]);
            session.setAttribute("loginError", dataErrorArray[1]);
            session.setAttribute("passwordError", dataErrorArray[2]);

            return "forward:/WEB-INF/views/SignUp.jsp";
        }

        try {
            User user = signUpService.RegisterUser(fullName, login, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/Home";
    }
}