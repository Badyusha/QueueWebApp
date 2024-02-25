package com.QueueWebApp.controllers;

import com.QueueWebApp.services.SessionService;
import com.QueueWebApp.services.SignUpService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String SignUp(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("fullName", null);
        session.setAttribute("login", null);
        session.setAttribute("fullNameError", null);
        session.setAttribute("loginError", null);
        session.setAttribute("passwordError", null);

        User user = SessionService.UserIsInSession(request);
        if(user == null) {
            return "forward:/WEB-INF/views/SignUp.jsp";
        }
        return "redirect:/Home";
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

        User user = signUpService.RegisterUser(fullName, login, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "redirect:/Home";
    }
}