package com.Tarea3.Ejercicios1_2_3.controller;

import com.Tarea3.Ejercicios1_2_3.entities.Laptop;
import com.Tarea3.Ejercicios1_2_3.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    private LaptopRepository laptopRepository;

    LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    /**
     * http://localhost:8080/api/laptops/
     * @return All laptops saved.
     */
    @GetMapping("/api/laptops/")
    @ApiOperation("List all laptops saved")
    public List<Laptop> findAll() {
        log.info("REST Request for find all Laptops");
        return laptopRepository.findAll();
    }

    /**
     * http://localhost:8080/api/laptops/{id}
     * @param id Laptop's Id.
     * @return The specified saved laptop.
     */
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("list a specific existent laptop")
    public ResponseEntity<Laptop>  findOneById(@PathVariable long id) {
        log.info("REST Request for find a Laptop");
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    /**
     * http://localhost:8080/api/laptops/
     * @param laptop JSON laptop object
     * @return The laptop created.
     */
    @PostMapping("/api/laptops/")
    @ApiOperation("Create and save a new laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        log.info("REST Request for create a Laptop");
        if(laptop.getId() != null ){
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);

    }

    /**
     * http://localhost:8080/api/laptops/
     * @param laptop JSON laptop object
     * @return The laptop updated.
     */
    @PutMapping("/api/laptops/")
    @ApiOperation("update a existent laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        log.info("REST Request for update a Laptop");
        if(laptop.getId() == null ){
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);

    }

    /**
     * http://localhost:8080/api/laptops/{id}
     * @param id Laptop's Id
     * @return No-content Http Status after deleting the specified object
     */
    @DeleteMapping("/api/laptops/{id}")
    @ApiOperation("Delete a specific existent laptop")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        log.info("REST Request for delete a Laptop");
        if (!laptopRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * http://localhost:8080/api/laptops/{id}
     * @return No-content Http Status after deleting all
     */
    @DeleteMapping("/api/laptops/")
    @ApiOperation("Delete all saved laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all Laptops");
        if (laptopRepository.count() == 0) {
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
