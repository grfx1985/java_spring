package com.wmusial.service;

import com.wmusial.dao.RentRepository;
import com.wmusial.model.Rent;
import com.wmusial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RentService {

    List<Rent> findByUser(User user);

    void save(Rent rent);
}
