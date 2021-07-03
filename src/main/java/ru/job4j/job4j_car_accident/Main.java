package ru.job4j.job4j_car_accident;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("secret");
        System.out.println(pwd);
        //$2a$10$EY0B/Ba6kIFCKNTVR.ghSOao.4vfiaBR9eXpmaNtKADn0PejujDYO
    }
}
