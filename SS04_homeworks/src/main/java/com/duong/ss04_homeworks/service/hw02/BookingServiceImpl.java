package com.duong.ss04_homeworks.service.hw02;

import com.duong.ss04_homeworks.dto.hw02.BookingViewDTO;
import com.duong.ss04_homeworks.dto.hw02.CreateBookingDTO;
import com.duong.ss04_homeworks.entity.Booking;
import com.duong.ss04_homeworks.entity.Flight;
import com.duong.ss04_homeworks.entity.enums.BookingStatus;
import com.duong.ss04_homeworks.repository.hw02.BookingRepository;
import com.duong.ss04_homeworks.repository.hw02.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FlightRepository flightRepo;

    @Override
    public void createBooking(CreateBookingDTO dto) {
        Flight flight = flightRepo.findById(dto.getFlightId()).orElse(null);
        if (flight == null) return;

        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setCustomerName(dto.getCustomerName());
        booking.setCustomerPhone(dto.getCustomerPhone());
        booking.setStatus(BookingStatus.BOOKED);

        bookingRepo.save(booking);
    }

    @Override
    public List<BookingViewDTO> getBookingsByPhone(String phone) {
        return bookingRepo.findByCustomerPhone(phone).stream()
                .map(b -> new BookingViewDTO(
                        b.getId(),
                        b.getFlight().getFlightNumber(),
                        b.getFlight().getDeparture(),
                        b.getFlight().getDestination(),
                        b.getFlight().getPrice(),
                        b.getCustomerName(),
                        b.getCustomerPhone(),
                        b.getBookingTime(),
                        b.getStatus()
                ))
                .toList();
    }

    @Override
    public void cancelBooking(int bookingId) {
        bookingRepo.findById(bookingId).ifPresent(b -> {
            b.setStatus(BookingStatus.CANCELLED);
            bookingRepo.save(b);
        });
    }
}
