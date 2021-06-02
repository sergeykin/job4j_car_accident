package ru.job4j.job4j_car_accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.job4j_car_accident.model.Accident;

import java.util.HashMap;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public static void main(String[] args) {
        AccidentMem accidentMem = AccidentMem.of();
        Accident accident1 = accidentMem.add(new Accident(1, "name1", "text1", "address1"));
        Accident accident2 = accidentMem.add(new Accident(2, "name2", "text2", "address2"));
        accidentMem.print();
        accidentMem.delete(accident1);
        accidentMem.print();
    }

    public static AccidentMem of() {
        AccidentMem accidentMem = new AccidentMem();
        return accidentMem;
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

    public HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }

    public void print() {
        if (accidents != null) {
            System.out.println(accidents);
        }
    }
}
