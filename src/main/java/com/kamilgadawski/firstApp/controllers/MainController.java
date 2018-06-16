package com.kamilgadawski.firstApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller // ta adnotacja musi być aby uruchomił się kontroler
public class MainController {

    @GetMapping ("/{age}/{name}")

    public String index(@PathVariable("age") int age,
                        @PathVariable("name") String name,
                        Model model){
        model.addAttribute("info", age >= 18 ? "Zapraszam do klubu" : "Wieczorynka");
        model.addAttribute("name", name);
        return "index.html";
    }
}
