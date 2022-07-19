package pl.sda.Projekt_Koncowy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import pl.sda.Projekt_Koncowy.service.impl.ThemovieDBServiceClass;
@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private ThemovieDBServiceClass themovieDBServiceClass;

    @Override
    public void run(String... args) throws Exception {
    themovieDBServiceClass.findAll();

    }
}
