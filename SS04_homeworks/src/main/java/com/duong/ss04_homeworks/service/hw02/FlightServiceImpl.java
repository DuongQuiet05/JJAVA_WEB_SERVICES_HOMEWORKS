package com.duong.ss04_homeworks.service.hw02;

import com.duong.ss04_homeworks.entity.Flight;
import com.duong.ss04_homeworks.repository.hw02.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepo;

    @Override
    public Page<Flight> searchFlights(String departure, String destination, int page, int size) {
        return flightRepo.findByDepartureContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                departure, destination, PageRequest.of(page, size));
    }

    @Override
    public Flight getFlightById(int id) {
        return flightRepo.findById(id).orElse(null);
    }
}
