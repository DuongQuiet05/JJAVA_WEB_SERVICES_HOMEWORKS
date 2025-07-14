package com.duong.ss04_homeworks.service.hw02;

import com.duong.ss04_homeworks.entity.Flight;
import org.springframework.data.domain.Page;

public interface FlightService {
    Page<Flight> searchFlights(String departure, String destination, int page, int size);
    Flight getFlightById(int id);
}
