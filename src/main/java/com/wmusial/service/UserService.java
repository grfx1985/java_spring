package com.wmusial.service;

import com.wmusial.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    void save(User user); // dla opcji logowania dodajemy extends
    List<User> findAll();

    void deleteById(Long id);

    User findById(Long id);

    User findByEmail(String email);
}
