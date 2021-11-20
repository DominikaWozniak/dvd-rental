package com.example.dvdrental.services.impl;

import com.example.dvdrental.model.Movie;
import com.example.dvdrental.repository.MovieRepository;
import com.example.dvdrental.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAllItems() {
        return movieRepository.findAll();
    }

    @Override
    public void saveItem(Movie item) {
        movieRepository.save(item);
    }

    @Override
    public Movie getItemById(Long id) {
        return movieRepository.getById(id);
    }

    @Override
    public void deleteItemById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findByCardId(Long id) {
        return movieRepository.findByRentCardId(id);
    }
}
