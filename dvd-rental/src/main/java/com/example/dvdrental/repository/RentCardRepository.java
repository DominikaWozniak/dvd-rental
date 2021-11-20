package com.example.dvdrental.repository;

import com.example.dvdrental.model.RentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentCardRepository extends JpaRepository<RentCard, Long> {

    @Query(value = "SELECT * FROM rent_card c WHERE c.customer_id = :id",
            nativeQuery = true)
    RentCard findByCustomerId(@Param("id") Long id);

}
