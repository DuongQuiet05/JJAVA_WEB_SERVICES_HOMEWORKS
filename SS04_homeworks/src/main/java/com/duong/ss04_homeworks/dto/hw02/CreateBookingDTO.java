package com.duong.ss04_homeworks.dto.hw02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingDTO {
    private Integer flightId;
    private String customerName;
    private String customerPhone;
}
