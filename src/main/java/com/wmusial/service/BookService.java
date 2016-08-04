package com.wmusial.service;

import com.wmusial.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    List<Book> findAll();

}
