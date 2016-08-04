package com.wmusial.dao.impl;

import com.wmusial.dao.BookRepository;
import com.wmusial.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll() {
        return null;
    }
}
