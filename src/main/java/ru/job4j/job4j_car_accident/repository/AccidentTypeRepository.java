package ru.job4j.job4j_car_accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.job4j_car_accident.model.AccidentType;

public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {
}
