package com.example.dvdrental.repository;

import com.example.dvdrental.model.Movie;
import com.example.dvdrental.model.RentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie m WHERE m.rent_card_id = :id",
            nativeQuery = true)
    List<Movie> findByRentCardId(@Param("id") Long id);
}
