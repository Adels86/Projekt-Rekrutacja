package pl.sda.Projekt_Koncowy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.Projekt_Koncowy.service.impl.MovieServiceImpl;
import pl.sda.Projekt_Koncowy.service.impl.UserServiceImpl;

public class StatisticsController {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private UserServiceImpl userService;


}
