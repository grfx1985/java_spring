package com.wmusial.dao;


import com.wmusial.model.Book;
import com.wmusial.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByAuthor(String author);
    List<Book> findByAvailableLessThan(int available);


//    List<Book> findAll();
}
