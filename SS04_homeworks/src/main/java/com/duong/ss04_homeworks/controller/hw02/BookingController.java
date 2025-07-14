package com.duong.ss04_homeworks.controller.hw02;

import com.duong.ss04_homeworks.dto.hw02.BookingViewDTO;
import com.duong.ss04_homeworks.dto.hw02.CreateBookingDTO;
import com.duong.ss04_homeworks.service.hw02.BookingService;
import com.duong.ss04_homeworks.service.hw02.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final FlightService flightService;

    @GetMapping("/new/{flightId}")
    public String showBookingForm(@PathVariable int flightId, Model model) {
        CreateBookingDTO dto = new CreateBookingDTO();
        dto.setFlightId(flightId);
        model.addAttribute("booking", dto);
        return "booking/form";
    }

    @PostMapping
    public String createBooking(@ModelAttribute("booking") CreateBookingDTO dto) {
        bookingService.createBooking(dto);
        return "redirect:/bookings/view?phone=" + dto.getCustomerPhone();
    }

    @GetMapping("/view")
    public String viewBookings(@RequestParam String phone, Model model) {
        List<BookingViewDTO> bookings = bookingService.getBookingsByPhone(phone);
        model.addAttribute("bookings", bookings);
        return "booking/list";
    }

    @GetMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable int id, @RequestParam String phone) {
        bookingService.cancelBooking(id);
        return "redirect:/bookings/view?phone=" + phone;
    }
}
