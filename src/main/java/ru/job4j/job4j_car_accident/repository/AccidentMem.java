package ru.job4j.job4j_car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.job4j_car_accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        Accident accident1 = accidents.put(1,new Accident(1, "name1", "text1", "address1"));
        Accident accident2 = accidents.put(2,new Accident(2, "name2", "text2", "address2"));
    }

    public Accident add(Accident accident) {
        accidents.put(accident.getId(), accident);
        return accidents.get(accident.getId());
    }

    public void delete(Accident accident) {
        if (accident != null) {
            accidents.remove(accident.getId());
        }
    }


    public Collection<Accident> getAccidents() {
        return accidents.values();
    }


}
