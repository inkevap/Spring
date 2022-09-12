package com.Tarea2.Ejercicios1_2_3.controller;

import com.Tarea2.Ejercicios1_2_3.entities.Laptop;
import com.Tarea2.Ejercicios1_2_3.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops/")
    public List<Laptop> findAll() {
        // recuperar y devolver los libros de base de datos
        return laptopRepository.findAll();
    }

    @PostMapping("/api/laptops/")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }

}
