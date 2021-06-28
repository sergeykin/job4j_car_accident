package ru.job4j.job4j_car_accident.service;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.model.AccidentType;
import ru.job4j.job4j_car_accident.model.Rule;
import ru.job4j.job4j_car_accident.repository.AccidentRepository;
import ru.job4j.job4j_car_accident.repository.AccidentTypeRepository;
import ru.job4j.job4j_car_accident.repository.RuleRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccidentService {
    AccidentRepository accidentRepository;
    AccidentTypeRepository accidentTypeRepository;
    RuleRepository ruleRepository;

    public AccidentService(AccidentRepository accidentRepository
            , AccidentTypeRepository accidentTypeRepository
            , RuleRepository ruleRepository) {
        this.accidentRepository = accidentRepository;
        this.accidentTypeRepository = accidentTypeRepository;
        this.ruleRepository = ruleRepository;
    }

    public Collection<Accident> getAccidents() {
        return accidentRepository.findAccidentAll();
    }

    public Collection<AccidentType> getAccidentTypes() {
        List<AccidentType> list = new ArrayList<>();
        accidentTypeRepository.findAll().forEach(list::add);
        return list;
    }

    public Collection<Rule> getRules() {
        List<Rule> list = new ArrayList<>();
        ruleRepository.findAll().forEach(list::add);
        return list;

    }

    public Accident getID(int id) {
        return accidentRepository.findById(id).get();
    }

    public Rule getRuleID(int id) {
        return ruleRepository.findById(id).get();
    }

    public AccidentType getTypeID(Integer id) {
        return accidentTypeRepository.findById(id).get();
    }

    @Transactional
    public Accident add(Accident accident) {
        accidentRepository.save(accident);
        return accident;
    }
}
