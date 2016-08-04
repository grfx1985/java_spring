package com.wmusial.dao.impl;

import com.wmusial.dao.BookRepository;
import com.wmusial.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

// @Repository
public class BookRepositoryImpl{  // usuniete implements BookRepository

    // @PersistenceContext
    private EntityManager entityManager;

    // @Override
//    public List<Book> findAll() {
//        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
//
//        List<Book> books = query.getResultList();
//
//        return books;
//    }
}
