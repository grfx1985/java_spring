package com.wmusial.controller;

import com.wmusial.model.Book;
import com.wmusial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
// @RequestMapping("/book") uzywany wszedzie tutaj, jesli to odkomentuje (cos jak scope w routes)
    public class BookController {


    @Autowired
    private BookService bookService;

    @RequestMapping(value="/books", method= RequestMethod.GET)
    public String getBooksPage(Model model, HttpSession session){


        List<Book> bookList = bookService.findAll();


//                new ArrayList<>();
//        Book book = new Book();
//        bookList.add(new Book("1","1",1));
//        bookList.add(new Book("2","2",2));
//        bookList.add(new Book("3","3",3));
//        bookList.add(new Book("4","4",4));

        model.addAttribute("bookList", bookList);

        return "books";
    }

    @RequestMapping(value="/book/create", method = RequestMethod.GET)
    public String getCreateBookString() {
        return "book-create";
    }

    @RequestMapping(value="/book/save", method = RequestMethod.POST)
    public String postCreateBook(@RequestParam(name = "author", required = true) String author,
                                 @RequestParam String title,
                                 @RequestParam int available) {
                                 // odebrac parametry z formularza


        // zrobic obiekty z parametrow
            Book book = new Book(author, title, available);
        // zapisac je do bazy
            bookService.save(book);


        // przekierowac uzytkownika do listy ksiazek

        return "redirect:/books";
    }


}
