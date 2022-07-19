package pl.sda.Projekt_Koncowy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.Projekt_Koncowy.model.Role;
import pl.sda.Projekt_Koncowy.model.User;
import pl.sda.Projekt_Koncowy.repository.UserRepository;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        final User userFromDB = userRepository.findByLogin(login);

        if (userFromDB == null) {
            throw new UsernameNotFoundException("Login " + login + " not found in database!");
        }

        return org.springframework.security.core.userdetails.User.builder() //inny User niż wyżej
                .username(userFromDB.getLogin())
                .password(userFromDB.getPassword())
                .roles(userFromDB.getRoles()
                        .stream()
                        .map(Role::getName)
                        .collect(Collectors.joining()))
                .build();
    }
}
