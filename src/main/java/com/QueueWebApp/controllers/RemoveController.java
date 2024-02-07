package com.QueueWebApp.controllers;

import com.QueueWebApp.bll.services.HomeService;
import com.QueueWebApp.bll.services.RemoveService;
import com.QueueWebApp.bll.services.SessionService;
import com.QueueWebApp.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RemoveController {
    private final RemoveService removeService;

    @Autowired
    public RemoveController(RemoveService removeService) {
        this.removeService = removeService;
    }

    @GetMapping("/Remove")
    public String SignIn(HttpServletRequest request) {
        User user = SessionService.UserIsInSession(request);
        if(user == null) {
            return "redirect:/SignIn";
        }

        // set the subjects list into session
        request.getSession().setAttribute("subjectsList",
                this.removeService.GetDataBaseService().GetUserSubjects(user.getId()));

        return "forward:/WEB-INF/views/Remove.jsp";
    }

    @PostMapping("/Remove")
    public String ProcessRemoveForm(@RequestParam String action,
                                    @RequestParam(required = false, name = "selectedSubjects") List<Long> selectedSubjects,
                                    HttpServletRequest request) {
        if (action.equals("cancel")) {
            return "redirect:/Home";
        }
        User user = SessionService.UserIsInSession(request);

        if (action.equals("remove") && selectedSubjects != null && !selectedSubjects.isEmpty()) {
            for (Long subjectId : selectedSubjects) {
                // Здесь выполните удаление выбранных очередей по их идентификаторам
                removeService.RemoveUserFromQueue(subjectId, user.getId());
            }
            // После удаления перенаправьте пользователя на домашнюю страницу или на другую страницу
            return "redirect:/Home";
        }

        return "redirect:/Remove";
    }

}