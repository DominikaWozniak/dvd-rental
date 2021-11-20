package com.example.dvdrental.services;

import com.example.dvdrental.model.Movie;

import java.util.List;

public interface MovieService extends CrudService<Movie>{

    List<Movie> findByCardId(Long id);
}
