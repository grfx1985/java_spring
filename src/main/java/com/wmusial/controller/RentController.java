package com.wmusial.controller;

import com.wmusial.dao.UserRepository;
import com.wmusial.model.Book;
import com.wmusial.model.Rent;
import com.wmusial.model.User;
import com.wmusial.service.BookService;
import com.wmusial.service.RentService;
import com.wmusial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller

public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/rents", method= RequestMethod.GET)
    public String getRentsPage(Model model, Principal principal) {

        String email = principal.getName();

        User user = userService.findByEmail(email);

        List<Rent> rents = rentService.findByUser(user);

        model.addAttribute("rents" , rents);


        return "rents";
    }

    @RequestMapping(value="/rent/book/{bookId}", method=RequestMethod.GET)
    public String rentBook(@PathVariable Long bookId, Principal principal) {
        Book book = bookService.findById(bookId);
        User user = userService.findByEmail(principal.getName());

        Rent rent = new Rent(book, user);
        rentService.save(rent);
        return "redirect:/rents";
    }
}
