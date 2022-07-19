package pl.sda.Projekt_Koncowy.service;

import pl.sda.Projekt_Koncowy.model.User;

public interface UserService {

    boolean existsByLogin(String login);

    void save(User user);

    long countOfUsers ();

    int yearWithTheMostCreatedAccounts();
}
