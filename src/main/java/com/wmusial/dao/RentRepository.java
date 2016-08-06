package com.wmusial.dao;

import com.wmusial.model.Book;
import com.wmusial.model.Rent;
import com.wmusial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    @Query("SELECT r FROM Rent r " +
            "LEFT JOIN FETCH r.user " +
            "LEFT JOIN FETCH r.book " +
            "WHERE r.user = :userParam")
    List<Rent> findByUser(@Param("userParam") User user);


//    @Query("SELECT r FROM Rent r " +
//            "LEFT JOIN FETCH r.user " +
//            "LEFT JOIN FETCH r.book " +
//            "WHERE r.user.email = :email")
//    List<Rent> findByUserEmail(@Param("email") String email);

    @Query("SELECT r FROM Rent r " +
            "LEFT JOIN FETCH r.book " +
            "WHERE r.id = :rParam")
    Rent findByRentId(@Param("rParam") Book book);
}
