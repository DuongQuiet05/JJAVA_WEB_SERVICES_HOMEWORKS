package com.duong.ss04_homeworks.controller.hw02;

import com.duong.ss04_homeworks.entity.Flight;
import com.duong.ss04_homeworks.service.hw02.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public String showFlights(
            @RequestParam(defaultValue = "") String departure,
            @RequestParam(defaultValue = "") String destination,
            @RequestParam(defaultValue = "0") int page,
            Model model) {
        Page<Flight> flightPage = flightService.searchFlights(departure, destination, page, 5);
        model.addAttribute("flights", flightPage.getContent());
        model.addAttribute("page", flightPage);
        model.addAttribute("departure", departure);
        model.addAttribute("destination", destination);
        return "flight/list";
    }
}
