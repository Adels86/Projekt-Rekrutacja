package pl.sda.Projekt_Koncowy.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.sda.Projekt_Koncowy.service.AutologinService;

@Slf4j
@Service
public class AutologinServiceImpl implements AutologinService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void autologin(String login) {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(login);

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails,
                        userDetails.getPassword(), userDetails.getAuthorities());

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            log.info("Successfully autologin user with login " + login);
        }
    }
}