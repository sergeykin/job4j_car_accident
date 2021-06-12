package ru.job4j.job4j_car_accident.control;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.repository.AccidentMem;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {
    private AccidentMem accidentMem = new AccidentMem();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "Petr Arsentev");


        model.addAttribute("accidentMem", accidentMem.getAccidents());
        return "index";
    }
}
