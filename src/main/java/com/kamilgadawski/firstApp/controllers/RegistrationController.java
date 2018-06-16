package com.kamilgadawski.firstApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    @ResponseBody
    public String registration (@RequestParam("login") String login,
                                @RequestParam("password") String password,
                                @RequestParam("returnPassword") String returnPassword,
                                @RequestParam("email") String email,
                                Model model){

        if (password.equals(returnPassword)){
            model.addAttribute("hasAccountCreated", true);
            return "Poprawnie";
        }
        model.addAttribute("hasAccountCreated", false);
        return "błędne dane";
    }
}
