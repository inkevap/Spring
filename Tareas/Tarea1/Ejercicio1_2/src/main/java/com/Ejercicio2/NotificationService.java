package com.Ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public void saludar(){
        System.out.println("Hola, soy un servicio de notificacion");
    }
}
