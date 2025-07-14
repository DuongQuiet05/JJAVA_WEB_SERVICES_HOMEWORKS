package com.duong.ss04_homeworks.repository.hw02;


import com.duong.ss04_homeworks.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByCustomerPhone(String phone);
}