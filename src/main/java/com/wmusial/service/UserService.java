package com.wmusial.service;

import com.wmusial.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void save(User user); // dla opcji logowania dodajemy extends
}
