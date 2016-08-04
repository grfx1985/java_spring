package com.wmusial.service.impl;


import com.wmusial.dao.BookRepository;
import com.wmusial.model.Book;
import com.wmusial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() { return null }
}
