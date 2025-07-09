package com.duong.ss02.repository;

import com.duong.ss02.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findBySeatNumber(String seatNumber);

    List<Seat> findByScreenRoomId(Long screenRoomId);
}