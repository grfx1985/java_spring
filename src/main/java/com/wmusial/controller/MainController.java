package com.wmusial.controller;

import com.wmusial.model.User;
import com.wmusial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    // root path ;) ?
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String getMainPage(){
        return "main";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping(value="/logout", method=RequestMethod.POST)
    public String postLogoutPage(){
        return "redirect:/login";
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String  getRegisterPage(){
        return "register";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String postCreateBook(@ModelAttribute User user) {

        // zapisac je do bazy
        userService.save(user);

        // przekierowac

        return "redirect:/login";
    }
}

// MainController
// /login -> chce zobaczyc login
// /register -> strona rejestracji

// BookController
// /books -> strona books.jsp