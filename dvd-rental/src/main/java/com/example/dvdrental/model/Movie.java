package com.example.dvdrental.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY,
            optional = false)
    private RentCard rentCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RentCard getRentCard() {
        return rentCard;
    }

    public void setRentCard(RentCard rentCard) {
        this.rentCard = rentCard;
    }
}
