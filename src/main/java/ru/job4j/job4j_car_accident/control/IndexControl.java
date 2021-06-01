package ru.job4j.job4j_car_accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "Petr Arsentev");
        List<String> list = new ArrayList<>();
        list.add("punkt1");
        list.add("punkt2");
        list.add("punkt3");
        list.add("punkt4");
        model.addAttribute("menu", list);
        return "index";
    }
}
