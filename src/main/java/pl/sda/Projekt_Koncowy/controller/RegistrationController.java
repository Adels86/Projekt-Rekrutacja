package pl.sda.Projekt_Koncowy.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.Projekt_Koncowy.model.User;

import pl.sda.Projekt_Koncowy.service.AutologinService;
import pl.sda.Projekt_Koncowy.service.UserService;

@Slf4j
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AutologinService autologinService;

    @GetMapping("/registration")
    public ModelAndView showRegistrationForm() {

        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


    @PostMapping("/register")
    public String handleNewUser(@ModelAttribute User user) {

        log.info("Received user: " + user);

        if (userService.existsByLogin(user.getLogin())) {
            log.info("User with login already exists  " + user.getLogin());
            return "registration";
        }

        userService.save(user);

        autologinService.autologin(user.getLogin());

        return "redirect:/movies";

    }

}
