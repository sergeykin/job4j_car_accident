package ru.job4j.job4j_car_accident.control;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.model.User;
import ru.job4j.job4j_car_accident.repository.AuthorityRepository;
import ru.job4j.job4j_car_accident.repository.UserRepository;

import java.util.List;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserRepository users;
    private final AuthorityRepository authorities;

    public RegControl(PasswordEncoder encoder, UserRepository users, AuthorityRepository authorities) {
        this.encoder = encoder;
        this.users = users;
        this.authorities = authorities;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {

        List<User> users1 = users.findByUsername(user.getUsername());
        if (!users1.isEmpty()) {
            return "reg";
        }

        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg(@ModelAttribute Accident accident) {
        return "reg";
    }
}
