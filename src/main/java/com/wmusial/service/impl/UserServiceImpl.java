package com.wmusial.service.impl;

import com.wmusial.dao.UserRepository;
import com.wmusial.model.User;
import com.wmusial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service  // dla opcji logowania dodajemy zeby config czytal
public class UserServiceImpl implements UserService {
                // alt + enter


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { // logujemy sie emailem - zmianiamy "s"
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Nie znaleziono Uzytkownika " + email );
        }

        return null;
    }
}
