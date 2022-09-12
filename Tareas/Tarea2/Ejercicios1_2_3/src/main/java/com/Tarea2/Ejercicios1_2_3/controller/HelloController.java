package com.Tarea2.Ejercicios1_2_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String holaMundo(){
        return "Hola, desde Hello Controller";
    }
}
