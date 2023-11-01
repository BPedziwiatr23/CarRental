package com.example.demo;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryCarRepository {
    private final List<CarEntity> cars = new ArrayList<>(List.of(
            CarEntity.builder().id(1L).carBrand("Opel").model("Astra").year(2016).build(),
            CarEntity.builder().id(2L).carBrand("Ford").model("Focus").year(2005).build(),
            CarEntity.builder().id(3L).carBrand("Mercedes").model("AMG GT").year(2021).build(),
            CarEntity.builder().id(4L).carBrand("Audi").model("A6").year(2019).build()
    ));
    public List<CarEntity> findAll() {
        return cars;
    }

    public CarEntity findById(Long id) {
        return cars.stream().filter(car -> id.equals(car.getId())).findFirst().orElseThrow();
    }

    public void save(CarEntity car) {
        var newId = cars.stream().map(CarEntity::getId).max(Comparator.naturalOrder()).orElseThrow();
        car.setId(++newId);
        cars.add(car);
    }
    public List<CarEntity> findByCarBrand(String carBrand) {
        return cars.stream().filter(car -> carBrand.equals(car.getCarBrand())).collect(Collectors.toList());
    }
    public List<CarEntity> findByModel(String model) {
        return cars.stream().filter(car -> model.equals(car.getModel())).collect(Collectors.toList());
    }
    public List<CarEntity> findByYear(Integer year) {
        return cars.stream().filter(car -> year.equals(car.getYear())).collect(Collectors.toList());
    }
    public void deleteById (Long id){
        CarEntity carToBeDeleted = cars.stream().filter(car -> id.equals(car.getId())).findFirst().orElseThrow();
        cars.remove(carToBeDeleted);
    }
}
