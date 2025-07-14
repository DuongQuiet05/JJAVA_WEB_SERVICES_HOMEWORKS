package com.duong.ss04_homeworks.service.hw02;

import com.duong.ss04_homeworks.dto.hw02.BookingViewDTO;
import com.duong.ss04_homeworks.dto.hw02.CreateBookingDTO;

import java.util.List;

public interface BookingService {
    void createBooking(CreateBookingDTO dto);
    List<BookingViewDTO> getBookingsByPhone(String phone);
    void cancelBooking(int bookingId);
}
