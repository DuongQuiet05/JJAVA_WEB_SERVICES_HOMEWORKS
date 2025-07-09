package com.duong.ss02.service;

import com.duong.ss02.entity.Showtime;
import com.duong.ss02.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService implements IService<Showtime, Long> {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Override
    public Showtime save(Showtime entity) {
        return showtimeRepository.save(entity);
    }

    @Override
    public Optional<Showtime> findById(Long id) {
        return showtimeRepository.findById(id);
    }

    @Override
    public Showtime update(Showtime entity) {
        return showtimeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        showtimeRepository.deleteById(id);
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public List<Showtime> filterShowtimes(Long movieId, LocalDate date, Long theaterId, Long screenRoomId) {
        return showtimeRepository.findByFilters(movieId, date, theaterId, screenRoomId);
    }
}