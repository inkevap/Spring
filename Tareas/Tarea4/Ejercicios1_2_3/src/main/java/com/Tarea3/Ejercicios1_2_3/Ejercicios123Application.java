
package com.Tarea3.Ejercicios1_2_3;

import com.Tarea3.Ejercicios1_2_3.entities.Laptop;
import com.Tarea3.Ejercicios1_2_3.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicios123Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Ejercicios123Application.class, args);
        LaptopRepository repository = context.getBean(LaptopRepository.class);

        Laptop laptop1 = new Laptop(null,16,256,"Intel i5","1366x728","Windows 7");
        Laptop laptop2 = new Laptop(null,8,1024,"Intel i5","1366x768","Windows 10");

        repository.save(laptop1);
        repository.save(laptop2);

    }

}
