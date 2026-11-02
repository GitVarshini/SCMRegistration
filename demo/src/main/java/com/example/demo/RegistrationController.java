package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration";
    }

    @PostMapping("/register")
    public String submitRegistration(@ModelAttribute("registration") Registration registration, Model model) {
        registrationService.register(registration);
        model.addAttribute("message", "Registration successful for " + registration.getName());
        return "success";
    }
}
