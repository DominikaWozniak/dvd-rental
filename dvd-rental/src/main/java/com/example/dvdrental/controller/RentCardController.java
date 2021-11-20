package com.example.dvdrental.controller;
import com.example.dvdrental.model.Customer;
import com.example.dvdrental.model.Movie;
import com.example.dvdrental.model.RentCard;
import com.example.dvdrental.services.MovieService;
import com.example.dvdrental.services.RentCardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class RentCardController {

    private RentCardService rentCardService;
    private MovieService movieService;

    public RentCardController(RentCardService rentCardService, MovieService movieService) {
        this.rentCardService = rentCardService;
        this.movieService = movieService;
    }

    @RequestMapping("/newCard/{id}")
    public String newCard(@PathVariable("id") Long id, Model model){
        RentCard rentCard = new RentCard();
        Customer customer = new Customer();
        customer.setId(id);
        rentCard.setCustomer(customer);
        model.addAttribute("newCard", rentCard);
        return "new_card";
    }

    @PostMapping("/saveCard")
    public String saveCard(@ModelAttribute("newCard") RentCard rentCard){
        rentCardService.saveItem(rentCard);
        return "redirect:/customers";
    }

    @GetMapping("/deleteCard/{id}")
    public String deleteCard(@PathVariable("id") Long id){
        RentCard rentCard = rentCardService.getItemById(id);
        this.rentCardService.deleteItemById(id);
        return "redirect:/";
    }

    @GetMapping("/cardById/{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        RentCard rentCard = rentCardService.findByCustomerId(id);
        List <Movie> movies = movieService.findByCardId(rentCard.getId());
        model.addAttribute("cardById", rentCard);
        model.addAttribute("moviesByCard", movies);
        return "card_by_id";
    }
}
