package com.example.dvdrental.controller;

import com.example.dvdrental.model.Movie;
import com.example.dvdrental.model.RentCard;
import com.example.dvdrental.services.MovieService;
import com.example.dvdrental.services.RentCardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    private MovieService movieService;
    private RentCardService rentCardService;

    public MovieController(MovieService movieService, RentCardService rentCardService) {
        this.movieService = movieService;
        this.rentCardService = rentCardService;
    }

    @RequestMapping("/addMovieToCard/{id}")
    public String newMovie(@PathVariable("id") Long id, Model model){
        Movie movie = new Movie();
        movie.setRentCard(rentCardService.getItemById(id));
        model.addAttribute("newMovie", movie);
        return "new_movie";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute("newMovie") Movie movie){
        movieService.saveItem(movie);
        return "redirect:/customers";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") Long id){
        this.movieService.deleteItemById(id);
        return "redirect:/customers";
    }

}
