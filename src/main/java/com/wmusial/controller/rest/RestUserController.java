package com.wmusial.controller.rest;

import com.wmusial.model.User;
import com.wmusial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RestUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/users" , method= RequestMethod.GET)
    public List<User> getUsers() {

        List<User> users = userService.findAll();

        return users;
    }
}
