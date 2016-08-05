package com.wmusial.dao;

import com.wmusial.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
}
