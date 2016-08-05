package com.wmusial.service.impl;

import com.wmusial.dao.UserRepository;
import com.wmusial.model.User;
import com.wmusial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user.getRole() == User.Role.ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // role jak dodamy spring zinterpretuje // premission jest druga opcja
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() { return userRepository.findAll(); }
}
