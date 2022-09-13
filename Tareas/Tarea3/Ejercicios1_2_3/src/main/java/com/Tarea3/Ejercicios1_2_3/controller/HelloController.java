package com.Tarea3.Ejercicios1_2_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController

public class HelloController {
    @ApiIgnore
    @GetMapping("/")
    public String holaMundo(){
        return "Hola, desde Hello Controller";
    }
}
