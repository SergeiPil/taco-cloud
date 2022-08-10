package com.piliugin.tacocloud.controller;

import com.piliugin.tacocloud.model.security.RegistrationForm;
import com.piliugin.tacocloud.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @ModelAttribute(name = "registerForm")
    public RegistrationForm form() {
        return new RegistrationForm();
    }

    @PostMapping
    public String processRegistration(@Valid RegistrationForm form, Errors errors) {
        if (errors.hasErrors()) {
            return "/registration";
        }
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
