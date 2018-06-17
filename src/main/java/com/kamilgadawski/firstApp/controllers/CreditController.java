package com.kamilgadawski.firstApp.controllers;


import com.kamilgadawski.firstApp.models.CreditForm;
import com.kamilgadawski.firstApp.models.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreditController {

    @GetMapping("/kredyt")
    public String kredyt(Model model){
        model.addAttribute("kredyt", new CreditForm());
        return "kredyt";
    }

    @PostMapping("/kredyt")
    @ResponseBody
    public String credit (@ModelAttribute CreditForm creditForm) {

        if (creditForm.getZarobki() - creditForm.getWydatki() > (creditForm.getWnioskowanaKwota() / creditForm.getMiesiace()) * 0.3 ){
//            model.addAttribute("kredyt", true);
            return "kredyt";
        }
//        model.addAttribute("kredyt", false);
        return "kredyt";
    }
}
