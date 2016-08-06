package com.wmusial.service;

import com.wmusial.model.Rent;
import com.wmusial.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RentService {

    List<Rent> findByUser(User user);

    void save(Rent rent);

    Rent findByRentId(Long rentId);
}
