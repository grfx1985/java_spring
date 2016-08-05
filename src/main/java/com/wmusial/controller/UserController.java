package com.wmusial.controller;

import com.wmusial.model.User;
import com.wmusial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value="/users", method= RequestMethod.GET)
    public String getUsersPage(Model model, HttpSession session){

        List<User> userList = userService.findAll();

        model.addAttribute("userList", userList);

        return "users";
    }

    @RequestMapping(value="/user/create", method = RequestMethod.GET)
    public String getCreateUserString(Model model) {

        model.addAttribute("user", new User());

        return "user-create";
    }


    @RequestMapping(value="/user/save", method = RequestMethod.POST)
    public String postCreateUser(@ModelAttribute User user) {

        // odebrac parametry z formularza

        // zapisac je do bazy
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

        String password = encoder.encode(user.getPassword());

        user.setPassword(password);

        userService.save(user);

        // przekierowac uzytkownika do listy ksiazek

        return "redirect:/users";
    }

    @RequestMapping(value="/user/delete/{id}", method = RequestMethod.POST)
    public String postDeleteBook(@PathVariable Long id) {

        userService.deleteById(id);

        return "redirect:/"; // javascript to ogarnie wiec moze byc nawet nic
    }

}
