package com.example.dvdrental.services.impl;

import com.example.dvdrental.model.RentCard;
import com.example.dvdrental.repository.RentCardRepository;
import com.example.dvdrental.services.RentCardService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentCardServiceImpl implements RentCardService {

    private RentCardRepository rentCardRepository;

    public RentCardServiceImpl(RentCardRepository rentCardRepository) {
        this.rentCardRepository = rentCardRepository;
    }

    @Override
    public List<RentCard> findAllItems() {
        return rentCardRepository.findAll();
    }

    @Override
    public void saveItem(RentCard item) {
        rentCardRepository.save(item);
    }

    @Override
    public RentCard getItemById(Long id) {
        return rentCardRepository.getById(id);
    }

    @Override
    public void deleteItemById(Long id) {
        rentCardRepository.deleteById(id);
    }

    @Override
    public RentCard findByCustomerId(Long id) {
        return rentCardRepository.findByCustomerId(id);
    }
}
