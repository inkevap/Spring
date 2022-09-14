package com.Tarea3.Ejercicios1_2_3.repository;

import com.Tarea3.Ejercicios1_2_3.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
