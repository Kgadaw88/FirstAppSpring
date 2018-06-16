package com.kamilgadawski.firstApp.controllers;


import com.kamilgadawski.firstApp.models.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController2 {

    @GetMapping("/registration2")
    public String registration(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "registration2";
    }

    @PostMapping("/registration2")
    @ResponseBody
    public String registration (@ModelAttribute RegisterForm registerForm) {


        if (registerForm.getPassword().equals(registerForm.getPasswordRepeat())){
            return "Zarejestrowano";
        }
        return "Błędne dane";
    }
}
