package com.duong.ss04_homeworks.repository.hw02;

import com.duong.ss04_homeworks.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Page<Flight> findByDepartureContainingIgnoreCaseAndDestinationContainingIgnoreCase(
            String departure, String destination, Pageable pageable);
}
