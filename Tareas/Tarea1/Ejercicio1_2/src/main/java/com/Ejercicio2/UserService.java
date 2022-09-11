package com.Ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    NotificationService notificationService;

    UserService(NotificationService notificationService){
        this.notificationService = notificationService;
    }
}
