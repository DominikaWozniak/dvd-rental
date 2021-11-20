package com.example.dvdrental.services;

import com.example.dvdrental.model.RentCard;


public interface RentCardService extends CrudService<RentCard>{

    RentCard findByCustomerId(Long id);

}
