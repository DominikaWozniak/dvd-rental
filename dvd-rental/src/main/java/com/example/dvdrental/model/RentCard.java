package com.example.dvdrental.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Customer customer;
    @OneToMany(mappedBy = "rentCard",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Movie> movieList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
