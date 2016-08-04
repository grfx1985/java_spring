package com.wmusial.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String  getRegisterPage(){
        return "register";
    }
}

// MainController
// /login -> chce zobaczyc login
// /register -> strona rejestracji

// BookController
// /books -> strona books.jsp