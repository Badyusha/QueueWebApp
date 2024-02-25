package com.QueueWebApp.controllers;

import com.QueueWebApp.services.SessionService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    @GetMapping("/Menu")
    public String Menu(HttpServletRequest request) {
        User user = SessionService.UserIsInSession(request);
        if(user == null) {
            return "redirect:/SignIn";
        }

        return "forward:/WEB-INF/views/Menu.jsp";
    }

    @PostMapping("/Menu")
    public String Menu(@RequestParam String action, HttpServletRequest request) {
        if(action.equals("profile")) {
            return "redirect:/Profile";
        }

        return "redirect:/Home";
    }
}
