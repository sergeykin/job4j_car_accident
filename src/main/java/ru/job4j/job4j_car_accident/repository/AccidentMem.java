package ru.job4j.job4j_car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.model.AccidentType;
import ru.job4j.job4j_car_accident.model.Rule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private AtomicInteger index = new AtomicInteger(0);
    private final HashMap<Integer,AccidentType> accidentTypes = new HashMap<>();
    private final HashMap<Integer,Rule> rules = new HashMap<>();

    public AccidentMem() {
        this.addType(AccidentType.of(1, "Две машины"));
        this.addType(AccidentType.of(2, "Машина и человек"));
        this.addType(AccidentType.of(3, "Машина и велосипед"));


        this.addRule(Rule.of(1, "Статья. 1"));
        this.addRule(Rule.of(2, "Статья. 2"));
        this.addRule(Rule.of(3, "Статья. 3"));


        Accident accident1 = this.add(new Accident(0, "name1", "text1", "address1",AccidentType.of(1,"type1")));
        Accident accident2 = this.add(new Accident(0, "name2", "text2", "address2",AccidentType.of(2,"type2")));
    }

    public Accident add(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(index.incrementAndGet());
        }
        accident.setType(accidentTypes.get(accident.getType().getId()));
        accidents.put(accident.getId(), accident);
        return accidents.get(accident.getId());
    }

    public AccidentType addType(AccidentType accidentType) {

        accidentTypes.put(accidentType.getId(), accidentType);
        return accidentTypes.get(accidentType.getId());
    }

    public Rule addRule(Rule rule) {

        rules.put(rule.getId(), rule);
        return rules.get(rule.getId());
    }

    public void delete(Accident accident) {
        if (accident != null) {
            accidents.remove(accident.getId());
        }
    }

    public Accident getID(Integer id) {
        return accidents.get(id);
    }

    public Rule getRuleID(Integer id) {
        return rules.get(id);
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

    public Collection<AccidentType> getAccidentTypes() {
        return accidentTypes.values();
    }

    public Collection<Rule> getRules() {
        return rules.values();
    }

}
