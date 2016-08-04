package com.wmusial.service.impl;


import com.wmusial.dao.BookRepository;
import com.wmusial.model.Book;
import com.wmusial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() { return bookRepository.findAll(); }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.delete(id);
    }
}
