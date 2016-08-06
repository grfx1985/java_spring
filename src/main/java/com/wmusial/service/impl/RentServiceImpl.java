package com.wmusial.service.impl;

import com.wmusial.dao.RentRepository;
import com.wmusial.model.Rent;
import com.wmusial.model.User;
import com.wmusial.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentRepository rentRepository;

    @Override
    public List<Rent> findByUser(User user) {
        return rentRepository.findByUser(user);
    }

    @Override
    public void save(Rent rent) {
        rentRepository.save(rent);
    }


    @Override
    public Rent findByRentId(Long rentId) {
        return rentRepository.findOne(rentId);
    }

    @Override
    public void deleteById(Long id) {
        rentRepository.delete(id);
    }

}
