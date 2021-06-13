package ru.job4j.job4j_car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.job4j_car_accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private AtomicInteger index = new AtomicInteger(0);

    public AccidentMem() {
        Accident accident1 = this.add(new Accident(0, "name1", "text1", "address1"));
        Accident accident2 = this.add(new Accident(0, "name2", "text2", "address2"));
    }

    public Accident add(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(index.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
        return accidents.get(accident.getId());
    }

    public void delete(Accident accident) {
        if (accident != null) {
            accidents.remove(accident.getId());
        }
    }

    public Accident getID(Integer id) {
        return accidents.get(id);
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }


}
