package com.wmusial.controller;

import com.wmusial.model.Book;
import com.wmusial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
// @RequestMapping("/book") uzywany wszedzie tutaj
    public class BookController {


    @Autowired
    private BookService bookService;

    @RequestMapping(value="/books", method= RequestMethod.GET)
    public String getBooksPage(Model model, HttpSession session){


        List<Book> bookList = bookService.findAll();


//                new ArrayList<>();

//        Book book = new Book();
//
//
//        bookList.add(new Book("1","1",1));
//        bookList.add(new Book("2","2",2));
//        bookList.add(new Book("3","3",3));
//        bookList.add(new Book("4","4",4));

        model.addAttribute("bookList", bookList);

        return "books";
    }




}
