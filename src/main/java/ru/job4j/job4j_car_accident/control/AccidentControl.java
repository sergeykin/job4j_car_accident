package ru.job4j.job4j_car_accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.model.AccidentType;
import ru.job4j.job4j_car_accident.repository.AccidentMem;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidents.getAccidentTypes());
        return "accident/create";
    }

    @GetMapping("/edit")
    public String edit(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Accident accident = accidents.getID(id);
        model.addAttribute("accident", accident);
        model.addAttribute("types", accidents.getAccidentTypes());
        return "accident/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accidents.add(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.getID(id));
        model.addAttribute("types", accidents.getAccidentTypes());
        return "accident/update";
    }
}
