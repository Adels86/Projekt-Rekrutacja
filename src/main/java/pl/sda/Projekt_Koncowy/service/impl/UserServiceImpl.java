package pl.sda.Projekt_Koncowy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.Projekt_Koncowy.model.Role;
import pl.sda.Projekt_Koncowy.model.User;
import pl.sda.Projekt_Koncowy.repository.RoleRepository;
import pl.sda.Projekt_Koncowy.repository.UserRepository;
import pl.sda.Projekt_Koncowy.service.UserService;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean existsByLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login is empty");
        }
        return userRepository.existsByLogin(login);
    }

    @Override
    public void save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null");
        }
        user.setPassword(getEncodedPassword(user.getPassword()));

        user.setRoles(getUserRoles());
        userRepository.save(user);
    }

    @Override
    public int yearWithTheMostCreatedAccounts() {
        List<User> users = userRepository.findAll();
        Map<Integer, Integer> yearsWithCreatedAccounts = new HashMap<>();
        for (User user : users) {
            Integer yearAsKey = user.getCreatingAccountDate().getYear();
            if (!(yearsWithCreatedAccounts.containsKey(yearAsKey))) {
                yearsWithCreatedAccounts.put(yearAsKey, 1);
            } else {
                yearsWithCreatedAccounts.put(yearAsKey, yearsWithCreatedAccounts.get(yearAsKey) + 1);
            }
        }
        return Collections.max(yearsWithCreatedAccounts.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    @Override
    public long countOfUsers() {
        return userRepository.count();
    }

    private String getEncodedPassword(String rawPassword) {
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    private List<Role> getUserRoles() {
        final Role roleUser = roleRepository.findByName("USER");
        return List.of(roleUser);
    }
}