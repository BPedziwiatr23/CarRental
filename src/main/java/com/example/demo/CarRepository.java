package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    List<CarEntity> findByCarBrand(String carBrand);
    List<CarEntity> findByModel(String model);
    List<CarEntity> findByYear(Integer year);
}
