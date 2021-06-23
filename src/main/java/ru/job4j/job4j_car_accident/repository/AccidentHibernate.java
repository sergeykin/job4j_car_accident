package ru.job4j.job4j_car_accident.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.model.AccidentType;
import ru.job4j.job4j_car_accident.model.Rule;


import java.util.Collection;
import java.util.List;

@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident add(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    public AccidentType addType(AccidentType accidentType) {
        try (Session session = sf.openSession()) {
            session.save(accidentType);
            return accidentType;
        }
    }

    public Rule addRule(Rule rule) {
        try (Session session = sf.openSession()) {
            session.save(rule);
            return rule;
        }
    }


    public Accident getID(Integer id) {
        try (Session session = sf.openSession()) {
            return session.get(Accident.class, id);
        }
    }

    public AccidentType getTypeID(Integer id) {
        try (Session session = sf.openSession()) {
            return session.get(AccidentType.class, id);
        }
    }

    public Rule getRuleID(Integer id) {
        try (Session session = sf.openSession()) {
            return session.get(Rule.class, id);
        }
    }

    public Collection<Accident> getAccidents() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("select accident from ru.job4j.job4j_car_accident.model.Accident accident", Accident.class)
                    .list();
        }
    }

    public Collection<AccidentType> getAccidentTypes() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("select accidentType from ru.job4j.job4j_car_accident.model.AccidentType accidentType", AccidentType.class)
                    .list();
        }
    }

    public Collection<Rule> getRules() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("select rule from ru.job4j.job4j_car_accident.model.Rule rule", Rule.class)
                    .list();
        }
    }

}
