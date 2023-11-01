package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/in-memory/cars")
@RequiredArgsConstructor
class InMemoryCarController {

    private final InMemoryCarRepository inMemoryCarRepository;

    @GetMapping
    List<CarEntity> findAll() {
        return inMemoryCarRepository.findAll();
    }

    @GetMapping("/{id}")
    CarEntity findById(@PathVariable Long id) {
        return inMemoryCarRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody CarEntity Car) {
        inMemoryCarRepository.save(Car);
    }

    @DeleteMapping
    void deleteById(Long id) {
        inMemoryCarRepository.deleteById(id);
    }

    @GetMapping("/filterByCarBrand")
    List<CarEntity> findByCarBrand(@RequestParam String carBrand) {
        return inMemoryCarRepository.findByCarBrand(carBrand);
    }
    @GetMapping("/filterByModel")
    List<CarEntity> findByModel(@RequestParam String model) {
        return inMemoryCarRepository.findByModel(model);
    }
    @GetMapping("/filterByYear")
    List<CarEntity> findByYear(@RequestParam Integer year) {
        return inMemoryCarRepository.findByYear(year);
    }
}
