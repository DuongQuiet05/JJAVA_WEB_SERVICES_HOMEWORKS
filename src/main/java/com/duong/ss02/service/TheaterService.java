package com.duong.ss02.service;

import com.duong.ss02.entity.Theater;
import com.duong.ss02.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService implements IService<Theater, Long> {

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public Theater save(Theater entity) {
        return theaterRepository.save(entity);
    }

    @Override
    public Optional<Theater> findById(Long id) {
        return theaterRepository.findById(id);
    }

    @Override
    public Theater update(Theater entity) {
        return theaterRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        theaterRepository.deleteById(id);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }
}