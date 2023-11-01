package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class InMemoryCarRepositoryTest {

    @InjectMocks
    private InMemoryCarRepository inMemoryCarRepository;

    @Test
    void shouldFindById() {
        // given
        var id = 1L;

        // when
        var response = inMemoryCarRepository.findById(id);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getCarBrand()).isEqualTo("Opel");
    }

    @Test
    void shouldThrowExceptionWhenThereIsNoCarWithGivenId() {
        // given
        var id = 100L;

        // when
        assertThatThrownBy(() -> inMemoryCarRepository.findById(id))
                .isInstanceOf(NoSuchElementException.class);

        // then
        // nothing to do
    }

    @Test
    void shouldFindAll() {
        // given
        // nothing to do

        // when
        var response = inMemoryCarRepository.findAll();

        // then
        assertThat(response).hasSize(4);
    }

    @Test
    void shouldSave() {
        // given
        var car = new CarEntity(5L, "Skoda", "Octavia", 2011);

        // when
        inMemoryCarRepository.save(car);

        // then
        assertThat(inMemoryCarRepository.findAll()).hasSize(5);
    }

    @Test
    void shouldFindByCarBrand() {
        // given
        var carBrand = "Ford";

        // when
        var response = inMemoryCarRepository.findByCarBrand(carBrand);

        // then
        assertThat(response).isNotNull();
        assertThat(response.get(0).getModel()).isEqualTo("Focus");
    }
    @Test
    void shouldFindByModel() {
        // given
        var model = "AMG GT";

        // when
        var response = inMemoryCarRepository.findByModel(model);

        // then
        assertThat(response).isNotNull();
        assertThat(response.get(0).getCarBrand()).isEqualTo("Mercedes");
    }
    @Test
    void shouldFindByYear() {
        // given
        var year = 2019;

        // when
        var response = inMemoryCarRepository.findByYear(year);

        // then
        assertThat(response).isNotNull();
        assertThat(response.get(0).getModel()).isEqualTo("A6");
    }

    @Test
    void shouldDeleteById() {
        // given
        var id = 1L;

        // when
        inMemoryCarRepository.deleteById(id);

        // then
        assertThat(inMemoryCarRepository.findAll()).hasSize(3);

    }


}