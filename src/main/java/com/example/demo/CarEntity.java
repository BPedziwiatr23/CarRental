package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;

@Entity
@Table(name = "Cars")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarEntity {
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "car_brand")
    String carBrand;
    @Column(name = "car_model")
    String model;
    @Column(name = "car_production_year")
    Integer year;
}
