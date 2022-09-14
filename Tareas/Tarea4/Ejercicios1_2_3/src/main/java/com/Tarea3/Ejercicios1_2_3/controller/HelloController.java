package com.Tarea3.Ejercicios1_2_3.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    @ApiIgnore
    @GetMapping("/")
    public String holaMundo(){
        System.out.println(message);
        return "Hola, desde Hello Controller";
    }
}
