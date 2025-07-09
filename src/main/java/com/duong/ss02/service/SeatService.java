package com.duong.ss02.service;

import com.duong.ss02.entity.Seat;
import com.duong.ss02.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatService implements IService<Seat, Long> {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Seat save(Seat entity) {
        return seatRepository.save(entity);
    }

    @Override
    public Optional<Seat> findById(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    public Seat update(Seat entity) {
        return seatRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        seatRepository.deleteById(id);
    }
}