package ru.job4j.job4j_car_accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.job4j_car_accident.model.Rule;

public interface RuleRepository extends CrudRepository<Rule, Integer> {

}
