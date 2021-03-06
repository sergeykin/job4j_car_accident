package ru.job4j.job4j_car_accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.model.AccidentType;
import ru.job4j.job4j_car_accident.model.Rule;
import ru.job4j.job4j_car_accident.repository.AccidentHibernate;
import ru.job4j.job4j_car_accident.repository.AccidentJdbcTemplate;
import ru.job4j.job4j_car_accident.repository.AccidentMem;
import ru.job4j.job4j_car_accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;


@Controller
public class AccidentControl {
    private final AccidentService accidents;

    public AccidentControl(AccidentService accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidents.getAccidentTypes());
        model.addAttribute("rules", accidents.getRules());
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
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {

        String[] ids = req.getParameterValues("rIds");
        Set<Rule> rules = new HashSet<>();

        for (String id : ids) {
            rules.add(accidents.getRuleID(Integer.parseInt(id)));
        }
        AccidentType accidentType= accidents.getTypeID(accident.getType().getId());
        accident.setType(accidentType);
        accident.setRules(rules);
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
