package com.duong.ss04_homeworks.dto.hw02;

import com.duong.ss04_homeworks.entity.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingViewDTO {
    private Integer id;
    private String flightNumber;
    private String departure;
    private String destination;
    private double price;
    private String customerName;
    private String customerPhone;
    private LocalDateTime bookingTime;
    private BookingStatus status;
}
