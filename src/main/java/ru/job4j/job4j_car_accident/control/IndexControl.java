package ru.job4j.job4j_car_accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.repository.AccidentHibernate;
import ru.job4j.job4j_car_accident.repository.AccidentJdbcTemplate;
import ru.job4j.job4j_car_accident.repository.AccidentRepository;
import ru.job4j.job4j_car_accident.service.AccidentService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
public class IndexControl {
    private final AccidentService accidents;

    public IndexControl(AccidentService accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> list = new ArrayList<>();
        accidents.getAccidents().forEach(list::add);
        model.addAttribute("accidents", list);
        model.addAttribute("user", "sega");
        return "index";
    }

//    private AccidentMem accidentMem = new AccidentMem();
//
//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("user", "Petr Arsentev");
//
//
//        model.addAttribute("accidentMem", accidentMem.getAccidents());
//        return "index";
//    }
}
