package ru.job4j.job4j_car_accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.repository.AccidentMem;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "Petr Arsentev");
        AccidentMem accidentMem = AccidentMem.of();
        Accident accident1 = accidentMem.add(new Accident(1, "name1", "text1", "address1"));
        Accident accident2 = accidentMem.add(new Accident(2, "name2", "text2", "address2"));

        model.addAttribute("accidentMem", accidentMem.getAccidents().values());
        return "index";
    }
}
