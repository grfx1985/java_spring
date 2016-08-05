package com.wmusial.service.impl;

import com.wmusial.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service  // dla opcji logowania dodajemy zeby config czytal
public class UserServiceImpl implements UserService {
                // alt + enter

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { // logujemy sie emailem - zmianiamy "s"

        return null;
    }
}
