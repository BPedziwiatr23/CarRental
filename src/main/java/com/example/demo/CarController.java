package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/in-database/cars")
@RequiredArgsConstructor
class CarController {

    private final com.example.demo.CarRepository CarRepository;

    @GetMapping
    List<CarEntity> findAll() {
        return CarRepository.findAll();
    }

    @GetMapping("/{id}")
    CarEntity findById(@PathVariable Long id) {
        return CarRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody CarEntity Car) {
        CarRepository.save(Car);
    }

    @DeleteMapping
    void deleteById(Long id) {
        CarRepository.deleteById(id);
    }

    @GetMapping("/filterByCarBrand")
    List<CarEntity> findByCarBrand(@RequestParam String carBrand) {
        return CarRepository.findByCarBrand(carBrand);
    }
    @GetMapping("/filterByModel")
    List<CarEntity> findByModel(@RequestParam String model) {
        return CarRepository.findByModel(model);
    }
    @GetMapping("/filterByYear")
    List<CarEntity> findByYear(@RequestParam Integer year) {
        return CarRepository.findByYear(year);
    }
}
