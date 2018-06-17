package com.kamilgadawski.firstApp.controllers;


import com.kamilgadawski.firstApp.models.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController2 {

    @GetMapping("/registration2")
    public String registration(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "registration2";
    }

    @PostMapping("/registration2")
    public String registration (@ModelAttribute @Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "registration2";
        }
        if (registerForm.getPassword().equals(registerForm.getPasswordRepeat())){
            return "redirect:/login";
        }
        return "redirect:/login";
    }
}
