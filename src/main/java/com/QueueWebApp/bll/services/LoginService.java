package com.QueueWebApp.bll.services;

public class LoginService {
    public boolean authenticate(String username, String password) {
        // Здесь должна быть реальная логика аутентификации, например, проверка в базе данных
        // Для примера просто проверим, совпадают ли значения с какими-то заранее заданными
        return "admin".equals(username) && "admin123".equals(password);
    }
}