package com.wmusial.controller;

import com.wmusial.model.Book;
import com.wmusial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
// @RequestMapping("/book") uzywany wszedzie tutaj, jesli to odkomentuje (cos jak scope w routes/rails)
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
    public String getCreateBookString(Model model) {

        model.addAttribute("book", new Book());

        return "book-create";
    }

    @RequestMapping(value="/book/save", method = RequestMethod.POST)
    public String postCreateBook(@ModelAttribute Book book) {
            // alternatywa dla @REQUESTPARAM to @ModelAttribute Book book
                                 // odebrac parametry z formularza
//        @RequestParam(name = "author", required = true) String author,
//        @RequestParam String title,
//        @RequestParam Long id,
//        @RequestParam int available

        // zrobic obiekty z parametrow
        // !! JESLI UZYJEMY @ModelAttribute ^^ to obiektu nizej juz nie trzeba
//            Book book = new Book(author, title, available);
//            book.setId(id);
        // zapisac je do bazy
            bookService.save(book);


        // przekierowac uzytkownika do listy ksiazek

        return "redirect:/books";
    }

    @RequestMapping(value="/book/edit/{id}", method = RequestMethod.GET)
    public String getEditBookForm(Model model,@PathVariable Long id) {

        Book book = bookService.findById(id);
        model.addAttribute("book",book);

        return "book-create";
    }

    @RequestMapping(value="/book/delete/{id}", method = RequestMethod.POST)
    public String postDeleteBook(@PathVariable Long id) {

        bookService.deleteById(id);

        return "redirect:/books"; // javascript to ogarnie wiec moze byc nawet nic
    }


}
